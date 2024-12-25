using System.Collections.Generic;
using System.Windows;
using System.Windows.Controls;
using ATM.Bus;
using ATM.DAO;
using ATM.Entities;
using ATMMetro2.View;

namespace ATMMetro2
{
    /// <summary>
    /// Interaction logic for App.xaml
    /// </summary>
    public partial class App : Application
    {
        public static Frame MainFrame = new Frame();
        public static AccountModel Acc = null;
        public static CardModel Card = null;
        public static List<ATMMoneyItem> MoneyStore = new List<ATMMoneyItem>();
        public static void Navigate(UserControl uc)
        {
            if (MainFrame == null)
            {
                MainFrame = new Frame();
            }
            else
            {
                MainFrame.NavigationService.RemoveBackEntry();
            }
            MainFrame.Navigate(uc);
        }

        public static void UpdateCurrentAccount()
        {
            Acc = AccountData.GetCurrentAccount(Card.ID);
        }

        public static void UpdateCurrentCard(string cardID)
        {
            Card = CardDAO.GetCurrentCard(cardID);
        }

        public static void WithdrawNavigate(float money)
        {
            switch (WithdrawMoneyBl.Withdraw(money, App.Card, App.Acc))
            {
                case 0:
                    Navigate(new WaitForMoneyView());
                    break;
                case 1:
                    Navigate(new Thankyou("ATM is not enough money or check your account and try again", false));
                    break;
            }
        }
    }
}
