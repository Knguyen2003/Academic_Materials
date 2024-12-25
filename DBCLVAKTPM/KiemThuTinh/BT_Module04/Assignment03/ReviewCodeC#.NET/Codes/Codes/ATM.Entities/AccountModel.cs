
﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace ATM.Entities
{
    public class AccountModel
    {
        public string ID { get; set; }
        public string CusID { get; set; }
        public float Balance { get; set; }
        public float OverDraft { get; set; }
        public string AccountType { get; set; }
        public float WithdrawLimit { get; set; }
        public float ODLimit { get; set; }
    }
}
