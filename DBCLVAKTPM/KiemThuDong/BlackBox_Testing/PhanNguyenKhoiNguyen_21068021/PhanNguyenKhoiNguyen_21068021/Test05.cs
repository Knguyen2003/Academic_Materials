using Microsoft.VisualStudio.TestTools.UnitTesting;
using System;
using System.Diagnostics.Eventing.Reader;

namespace PhanNguyenKhoiNguyen_21068021
{
    [TestClass]
    public class Test05
    {
        [TestMethod()]
        public void testValidPartition_1()
        {
            MethodLibrary.MethodLibrary o = new MethodLibrary.MethodLibrary();
            String sbin = "101010111";
            long expectedResult = 343;
            long actualResult = o.BinToDec("101010111");
            Assert.AreEqual(expectedResult, actualResult);
        }


        [TestMethod()]
        public void testInvalidPartition_2()
        {
            MethodLibrary.MethodLibrary o = new MethodLibrary.MethodLibrary();
            Exception expectedException = null;
            try
            {
                o.BinToDec("102601205");
            }
            catch (Exception ex)
            {
                // Catches the exception
                expectedException = ex;
            }
            Assert.IsNotNull(expectedException);
        }

        [TestMethod()]
        public void testInvalidPartition_3()
        {
            MethodLibrary.MethodLibrary o = new MethodLibrary.MethodLibrary();
            Exception expectedException = null;
            try
            {
                o.BinToDec("");
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
