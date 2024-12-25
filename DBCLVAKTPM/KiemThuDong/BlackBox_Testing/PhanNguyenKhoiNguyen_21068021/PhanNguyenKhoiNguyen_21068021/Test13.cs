using Microsoft.VisualStudio.TestTools.UnitTesting;
using System;

namespace PhanNguyenKhoiNguyen_21068021
{
    [TestClass]
    public class Test13
    {
        [TestMethod]
        public void testValidPartition_01()
        {
            MethodLibrary.MethodLibrary m = new MethodLibrary.MethodLibrary();
            int[] a = { 1, 2, 3, 2, 1, 5, 9 };
            int n = 5;
            bool expectedResult = true;
            bool actualResult = m.IsSymmetry(a, n);
            Assert.AreEqual(expectedResult, actualResult);
        }

        [TestMethod]
        public void testValidPartition_02()
        {
            MethodLibrary.MethodLibrary m = new MethodLibrary.MethodLibrary();
            int[] a = { 1, 2, 3, 4, 5, 6, 1 };
            int n = 5;
            bool expectedResult = false;
            bool actualResult = m.IsSymmetry(a, n);
            Assert.AreEqual(expectedResult, actualResult);
        }

        [TestMethod]
        public void testValidBoundary_03()
        {
            MethodLibrary.MethodLibrary m = new MethodLibrary.MethodLibrary();
            int[] a = { 1, 2, 3, 4, 5, 6, 1 };
            int n = 1;
            bool expectedResult = true;
            bool actualResult = m.IsSymmetry(a, n);
            Assert.AreEqual(expectedResult, actualResult);
        }

        [TestMethod]
        public void testValidBoundary_04()
        {
            MethodLibrary.MethodLibrary m = new MethodLibrary.MethodLibrary();
            int[] a = { 1, 2, 3, 5, 3, 2, 1 };
            int n = 7;
            bool expectedResult = true;
            bool actualResult = m.IsSymmetry(a, n);
            Assert.AreEqual(expectedResult, actualResult);
        }


        [TestMethod]
        public void testInvalidPartition_05()
        {
            MethodLibrary.MethodLibrary m = new MethodLibrary.MethodLibrary();
            int[] a = {};
            int n = 5;
            bool expectedResult = false;
            bool actualResult = m.IsSymmetry(a, n);

            Assert.AreEqual(expectedResult, actualResult);
        }

        [TestMethod]
        public void testInvalidPartition_06()
        {
            MethodLibrary.MethodLibrary m = new MethodLibrary.MethodLibrary();
            int[] a = { 1, 2, 3, 4, 5, 6, 1 };
            int n = -1;
            bool expectedResult = false;
            bool actualResult = m.IsSymmetry(a, n);
            Assert.AreEqual(expectedResult, actualResult);
        }

        [TestMethod]
        public void testInvalidPartition_07()
        {
            MethodLibrary.MethodLibrary m = new MethodLibrary.MethodLibrary();
            int[] a = { 1, 2, 3, 4, 5, 6, 1 };
            int n = 15;
            bool expectedResult = false;
            bool actualResult = m.IsSymmetry(a, n);
            Assert.AreEqual(expectedResult, actualResult);
        }

        [TestMethod]
        public void testInvalidBoundary_08()
        {
            MethodLibrary.MethodLibrary m = new MethodLibrary.MethodLibrary();
            int[] a = { 1, 2, 3, 4, 5, 6, 1 };
            int n = 0;
            bool expectedResult = true;
            bool actualResult = m.IsSymmetry(a, n);
            Assert.AreEqual(expectedResult, actualResult);
        }


        [TestMethod]
        public void testInvalidBoundary_09()
        {
            MethodLibrary.MethodLibrary m = new MethodLibrary.MethodLibrary();
            int[] a = { 1, 2, 3, 4, 5, 6, 1 };
            int n = 8;
            bool expectedResult = false;
            bool actualResult = m.IsSymmetry(a, n);
            Assert.AreEqual(expectedResult, actualResult);
        }

    }
}
