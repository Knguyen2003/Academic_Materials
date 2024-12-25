using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace ATM.Entities
{
    public class CardModel
    {
        public string ID { get; set; }
        public string pin { get; set; }
        public string status { get; set; }
        public string AccID { get; set; }
        public string CreateDate { get; set; }
        public string ExpiredDate { get; set; }
    }
}
