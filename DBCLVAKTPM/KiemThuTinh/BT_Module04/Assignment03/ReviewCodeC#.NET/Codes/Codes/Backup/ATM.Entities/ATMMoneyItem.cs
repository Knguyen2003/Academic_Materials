using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace ATM.Entities
{
    public class ATMMoneyItem
    {
        public float Denomination { get; set; }
        public string Currency { get; set; }
        public int Quantity { set; get; }
    }
}
