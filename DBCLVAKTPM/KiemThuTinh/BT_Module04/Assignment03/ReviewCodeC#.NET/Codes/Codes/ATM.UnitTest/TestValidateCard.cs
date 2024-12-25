using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using NUnit.Framework;
using ATM.Entities;
using ATM.Bus;
namespace ATM.UnitTest
{
    [TestFixture]
    class TestValidateCard
    {
        [Test]
        public  void TestValidateAccount()
        {
            string cardID = "1234567891234568";
            CardModel validateCard = ATM.DAO.ValidateUserCardbll.ValidateCard(cardID);

            Assert.AreEqual(1, ValidationBus.ValadateCardID(validateCard.ID));
        }
        [Test]
        public void TestValidateAccount_Case2()
        {
            string cardID = "1234567891234567";
            CardModel validateCard = ATM.DAO.ValidateUserCardbll.ValidateCard(cardID);

            Assert.AreEqual(0, ValidationBus.ValadateCardID(validateCard.ID));
        }
        [Test]
        public void TestValidateAccount_Case3()
        {
            string cardID = "123456789";
            CardModel validateCard = ATM.DAO.ValidateUserCardbll.ValidateCard(cardID);

            Assert.AreEqual(2, ValidationBus.ValadateCardID(validateCard.ID));
        }
        
    }
}
