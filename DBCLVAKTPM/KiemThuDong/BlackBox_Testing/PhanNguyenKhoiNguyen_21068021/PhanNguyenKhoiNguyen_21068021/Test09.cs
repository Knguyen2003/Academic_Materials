using Microsoft.VisualStudio.TestTools.UnitTesting;
using System;

namespace PhanNguyenKhoiNguyen_21068021
{
    [TestClass]
    public class Test09
    {
        [TestMethod]
        public void testValidPartition_01()
        {
            MethodLibrary.MethodLibrary m = new MethodLibrary.MethodLibrary();
            long s0 = 10;
            long s;
            long expectedResult = 15;
            long actualResult = m.Sum(s0, out s);
            Assert.AreEqual(expectedResult, actualResult);
        }

        [TestMethod]
        public void testValidPartition_02()
        {
            MethodLibrary.MethodLibrary m = new MethodLibrary.MethodLibrary();
            long s0 = -10;
            long s;
            long expectedResult = 1;
            long actualResult = m.Sum(s0, out s);
            Assert.AreEqual(expectedResult, actualResult);

        }

        [TestMethod]
        public void testValidBoundary_03()
        {
            MethodLibrary.MethodLibrary m = new MethodLibrary.MethodLibrary();
            long s0 = 0;
            long s;
            long expectedResult = 1;
            long actualResult = m.Sum(s0, out s);
            Assert.AreEqual(expectedResult, actualResult);
        }

        [TestMethod]
        public void testValidBoundary_04()
        {
            MethodLibrary.MethodLibrary m = new MethodLibrary.MethodLibrary();
            long s0 = 1;
            long s;
            long expectedResult = 1;
            long actualResult = m.Sum(s0, out s);
            Assert.AreEqual(expectedResult, actualResult);
        }
    }
}

