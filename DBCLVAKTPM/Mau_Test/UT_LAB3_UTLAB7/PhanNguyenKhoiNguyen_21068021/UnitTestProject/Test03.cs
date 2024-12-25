using Microsoft.VisualStudio.TestTools.UnitTesting;
using System;

namespace UnitTestProject
{
    [TestClass]
    public class Test03
    {
        //For valid partition
        [TestMethod]
        public void testPrimne_true()
        {
            MethodLibrary.MethodLibrary o = new MethodLibrary.MethodLibrary();
            bool actual = o.primeCheck(17);
            bool expectedResult = true;

            Assert.AreEqual(expectedResult, actual);

        }

        [TestMethod]
        public void testPrimne_false()
        {
            MethodLibrary.MethodLibrary o = new MethodLibrary.MethodLibrary();
            bool actual = o.primeCheck(25);
            bool expectedResult = false;

            Assert.AreEqual(expectedResult, actual);

        }

        //For valid boundary
        [TestMethod]
        public void testValidBoundary_1()
        {
            MethodLibrary.MethodLibrary o = new MethodLibrary.MethodLibrary();
            bool actual = o.primeCheck(0);
            bool expectedResult = false;

            Assert.AreEqual(expectedResult, actual);

        }

        [TestMethod]
        public void testValidBoundary_2()
        {
            MethodLibrary.MethodLibrary o = new MethodLibrary.MethodLibrary();
            bool actual = o.primeCheck(1000);
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
                o.primeCheck(-5);
            }
            catch (Exception ex)
            {
                // Catches the exception
                expectedException = ex;
            }
            Assert.IsNotNull(expectedException);

        }

        [TestMethod()]
        public void testInvalidPartition_2()
        {
            MethodLibrary.MethodLibrary o = new MethodLibrary.MethodLibrary();
            Exception expectedException = null;
            try
            {
                o.primeCheck(2000);
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
                o.primeCheck(-1);
            }
            catch (Exception ex)
            {
                // Catches the exception
                expectedException = ex;
            }
            Assert.IsNotNull(expectedException);
        }


        [TestMethod()]
        public void testInvalidBoundary_2()
        {
            MethodLibrary.MethodLibrary o = new MethodLibrary.MethodLibrary();
            Exception expectedException = null;
            try
            {
                o.primeCheck(1001);
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
