using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using ATM.Common;
using ATM.DAO;
using ATM.Entities;

namespace ATM.Bus
{
    public class WithdrawMoneyBl
    {
        private static List<ATMMoneyItem> _list = null;
        private static List<ATMMoneyItem> _listOfWithdraw = null;

        public WithdrawMoneyBl()
        {
            _list = ATMDAO.GetMoneyStore();
        }

        public static float Sum()
        {
            _list = ATMDAO.GetMoneyStore();
            float sum = 0;
            for (int i = 0; i < _list.Count; i++)
            {
                sum += _list[i].Denomination * _list[i].Quantity;
            }
            return sum;
        }
        /// <summary>
        /// Find a solution to give money back to user
        /// </summary>
        /// <param name="money"></param>
        /// <returns>
        /// List of denominations to return to user
        /// </returns>
        public static List<ATMMoneyItem> Solution(float money)
        {
            var list = new List<ATMMoneyItem>();

            _list = _list.OrderBy(x => x.Denomination).ToList();
            _list.Reverse();

            float withdrawalMoney = money;


            foreach (ATMMoneyItem t in _list)
                if (withdrawalMoney > 0)
                {
                    var temp = (int)(withdrawalMoney / t.Denomination);
                    var item = new ATMMoneyItem
                               {
                                   Currency = ConstParameters.CURRENCY, 
                                   Denomination = t.Denomination
                               };
                    if (temp < t.Quantity)
                    {
                        withdrawalMoney -= t.Denomination * temp;
                        item.Quantity = temp;
                    }

                    else
                    {
                        withdrawalMoney -= t.Denomination * t.Quantity;
                        item.Quantity = t.Quantity;
                    }
                    list.Add(item);
                }

            return list;
        }

        /// <summary>
        /// Check if ATM can return the wanted money
        /// </summary>
        /// <param name="money">Wanted money</param>
        /// <returns></returns>
        public static bool CanSolve(float money)
        {
            _listOfWithdraw = Solution(money);
            if (_listOfWithdraw.Count != 0) return true;
            return false;
        }

        /// <summary>
        /// Check if remaining money in account can be enough to withdraw
        /// </summary>
        /// <param name="wdMoney"></param>
        /// <param name="accMoney"></param>
        /// <param name="accOd"></param>
        /// <returns>
        /// true: money is enough
        /// false: not enough
        /// </returns>
        public static bool IsAccountEnough(float wdMoney, float accMoney, float accOd)
        {
            if (wdMoney > accMoney)
            {
                if ((accOd >= ConstParameters.OVERDRAFT_LIMIT)
                    || (wdMoney > (accMoney + (ConstParameters.OVERDRAFT_LIMIT - accOd))))
                    return false;
            }
            return true;
        }

        /// <summary>
        /// Check if can withdraw with "money" if account has "accMoney" 
        /// and overdraft is "od"
        /// </summary>
        /// <param name="money">the amount of money wished to withdraw</param>
        /// <param name="accMoney">the money remains in account</param>
        /// <param name="od">the current overdraft of account</param>
        /// <returns>
        /// true: if can withdraw
        /// false: if not
        /// </returns>
        public static bool CanWithdraw(float money, float accMoney, float od)
        {
            if ((money <= Sum()) && (IsAccountEnough(money, accMoney, od)) && (CanSolve(money)))
                return true;
            return false;
        }

        /// <summary>
        /// Update all data in server DB and ATM DB
        /// </summary>
        /// <param name="cardId"></param>
        /// <param name="money"></param>
        public static void UpdateAllData(string cardId, float money)
        {
            AccountData.UpdateAccountMoney(cardId, money);
            ATMDAO.UpdateAtmDatabase(_listOfWithdraw);
        }

        /// <summary>
        /// 
        /// </summary>
        /// <param name="money"></param>
        /// <returns>
        /// 0: Can Withdraw and navigate to WaitForMoneyView.
        /// 1: Can not withdraw and navigate to Thankyou.
        /// </returns>
        public static int Withdraw(float money, CardModel Card, AccountModel Acc)
        {
            if (CanWithdraw(money, Acc.Balance, Acc.OverDraft))
            {
                UpdateAllData(Card.ID, money);
                return 0;
            }
            return 1;
        }
    }
}
