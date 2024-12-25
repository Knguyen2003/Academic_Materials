using Microsoft.VisualStudio.TestTools.UnitTesting;
using System;

namespace PhanNguyenKhoiNguyen_21068021
{
    [TestClass]
    public class Test04
    {
        //For valid partition
        [TestMethod]
        public void testValidPartion_true1()
        {
            MethodLibrary.MethodLibrary o = new MethodLibrary.MethodLibrary();
            bool actual = o.IsLeapYear(2000);
            bool expectedResult = true;

            Assert.AreEqual(expectedResult, actual);

        }

        [TestMethod]
        public void testValidPartion_true2()
        {
            MethodLibrary.MethodLibrary o = new MethodLibrary.MethodLibrary();
            bool actual = o.IsLeapYear(2024);
            bool expectedResult = true;

            Assert.AreEqual(expectedResult, actual);

        }

        [TestMethod]
        public void testValidPartion_flase1()
        {
            MethodLibrary.MethodLibrary o = new MethodLibrary.MethodLibrary();
            bool actual = o.IsLeapYear(1900);
            bool expectedResult = false;

            Assert.AreEqual(expectedResult, actual);

        }
        //For valid boundary
        [TestMethod]
        public void testValidBoundary_flase2()
        {
            MethodLibrary.MethodLibrary o = new MethodLibrary.MethodLibrary();
            bool actual = o.IsLeapYear(1582);
            bool expectedResult = false;

            Assert.AreEqual(expectedResult, actual);

        }

        //For invalid partition
        [TestMethod()]
        public void testInvalidPartition_1()
        {
            MethodLibrary.MethodLibrary o = new MethodLibrary.MethodLibrary();
            Exception expectedException = null;
            try
            {
                o.IsLeapYear(1200);
            }
            catch (Exception ex)
            {
                // Catches the exception
                expectedException = ex;
            }
            Assert.IsNotNull(expectedException);

        }


        //For invalid boundary

        [TestMethod()]
        public void testInvalidBoundary_1()
        {
            MethodLibrary.MethodLibrary o = new MethodLibrary.MethodLibrary();
            Exception expectedException = null;
            try
            {
                o.IsLeapYear(1581);
            }
            catch (Exception ex)
            {
                // Catches the exception
                expectedException = ex;
            }
            Assert.IsNotNull(expectedException);
        }
    }
}
