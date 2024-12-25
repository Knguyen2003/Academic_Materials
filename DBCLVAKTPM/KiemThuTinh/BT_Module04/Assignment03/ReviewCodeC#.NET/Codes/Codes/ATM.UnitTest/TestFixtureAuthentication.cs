using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using ATM.Bus;
using ATM.DAO;
using ATM.Entities;
using NUnit.Framework;

namespace ATM.UnitTest
{
    [TestFixture]
    public class TestFixtureAuthentication
    {
        [Test]
        public void TestAuthentication_case1()
        {
            string cardID = "1234567891234569";
            CardModel card = CardDAO.GetCurrentCard(cardID);
            string pass = "123456";
            int count = 1;

            Assert.AreEqual(2, ValidationBus.Authentication(card, pass, count));
        }

        [Test]
        public void TestAuthentication_case2()
        {
            string cardID = "1234567891234569";
            CardModel card = CardDAO.GetCurrentCard(cardID);
            string pass = "111111";
            int count = 1;

            Assert.AreEqual(0, ValidationBus.Authentication(card, pass, count));
        }

        [Test]
        public void TestAuthentication_case3()
        {
            string cardID = "1234567891234569";
            CardModel card = CardDAO.GetCurrentCard(cardID);
            string pass = "123456";
            int count = 4;

            Assert.AreEqual(1, ValidationBus.Authentication(card, pass, count));
        }
    }
}
