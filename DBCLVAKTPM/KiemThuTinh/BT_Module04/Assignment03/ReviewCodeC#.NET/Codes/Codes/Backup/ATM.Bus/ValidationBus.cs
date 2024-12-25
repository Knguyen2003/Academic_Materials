using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using ATM.DAO;
using ATM.Entities;

namespace ATM.Bus
{
    public class ValidationBus
    {
        public static int ValadateCardID(string cardID)
        {
            CardModel card = ValidateUserCardbll.ValidateCard(cardID);
            if (card.ID != null)
            {
                return card.status.Equals("1") ? 1 : 0;
            }
            return 2;
        }

        public static string GetCusNameFromCardID(string cardID)
        {
            return "";
        }

        public static int Authentication(CardModel card, string pass, int count)
        {
            if (card.pin != pass)
            {
                if (count < 3)
                {
                    return 2;
                }
                else
                {
                    AuthenticateUserbll.UpdateStatus(card.ID);
                    return 1;
                }
            }
            return 0;
        }

        public static string GetCusName(string accID)
        {
            return CustomerData.getCustomerName(CustomerData.getCustomerID(accID));
        }
    }
}
