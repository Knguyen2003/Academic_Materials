using Microsoft.VisualStudio.TestTools.UnitTesting;
using System;

namespace PhanNguyenKhoiNguyen_21068021
{
    [TestClass]
    public class Test14
    {
        // Valid Partition
        [TestMethod]
        public void testValidPatition_01()
        {
            MethodLibrary.MethodLibrary o = new MethodLibrary.MethodLibrary();
            int[] list = { 7, 2, 1, 6, 8, 5, 3, 4 };
            int left = 2;
            int right = 5;
            o.QuickSort(list, left, right);
            int[] expectedResult = { 7, 2, 1, 5, 6, 8, 3, 4 };

            CollectionAssert.AreEqual(expectedResult, list);
        }

        [TestMethod]
        public void testValidPatition_02()
        {
            MethodLibrary.MethodLibrary o = new MethodLibrary.MethodLibrary();
            int[] list = { 7, 2, 1, 6, 8, 5, 3, 4 };
            int left = 7;
            int right = 5;
            o.QuickSort(list, left, right);
            int[] expectedResult = { 7, 2, 1, 6, 8, 5, 3, 4 };

            CollectionAssert.AreEqual(expectedResult, list);
        }

        // Valid Boundary
        [TestMethod]
        public void testValidBoundary_03()
        {
            MethodLibrary.MethodLibrary o = new MethodLibrary.MethodLibrary();
            int[] list = { 7, 2, 1, 6, 8, 5, 3, 4 };
            int left = 0;
            int right = 0;
            o.QuickSort(list, left, right);
            int[] expectedResult = { 7, 2, 1, 6, 8, 5, 3, 4 };

            CollectionAssert.AreEqual(expectedResult, list);
        }

        [TestMethod]
        public void testValidBoundary_4()
        {
            MethodLibrary.MethodLibrary o = new MethodLibrary.MethodLibrary();
            int[] list = { 7, 2, 1, 6, 8, 5, 3, 4 };
            int left = 6;
            int right = 7;
            o.QuickSort(list, left, right);
            int[] expectedResult = { 7, 2, 1, 6, 8, 5, 3, 4 };

            CollectionAssert.AreEqual(expectedResult, list);
        }

        [TestMethod]
        public void testValidBoundary_05()
        {
            MethodLibrary.MethodLibrary o = new MethodLibrary.MethodLibrary();
            int[] list = { 7, 2, 1, 6, 8, 5, 3, 4 };
            int left = 7;
            int right = 7;
            o.QuickSort(list, left, right);
            int[] expectedResult = { 7, 2, 1, 6, 8, 5, 3, 4 };

            CollectionAssert.AreEqual(expectedResult, list);
        }


        [TestMethod]
        public void testInvalidPatition_06()
        {
            MethodLibrary.MethodLibrary o = new MethodLibrary.MethodLibrary();
            int[] list = {};
            int left = 0;
            int right = 2;
            o.QuickSort(list, left, right);
            int[] expectedResult = {};

            CollectionAssert.AreEqual(expectedResult, list);
        }

        [TestMethod]
        public void testInvalidPatition_07()
        {
            MethodLibrary.MethodLibrary o = new MethodLibrary.MethodLibrary();
            int[] list = { 7, 2, 1, 6, 8, 5, 3, 4 };
            int left = -6;
            int right = 2;
            o.QuickSort(list, left, right);
            int[] expectedResult = { 1, 2, 7, 6, 8, 5, 3, 4 };

            CollectionAssert.AreEqual(expectedResult, list);
        }

        [TestMethod]
        public void testInvalidPatition_08()
        {
            MethodLibrary.MethodLibrary o = new MethodLibrary.MethodLibrary();
            int[] list = { 7, 2, 1, 6, 8, 5, 3, 4 };
            int left = 0;
            int right = -6;
            o.QuickSort(list, left, right);
            int[] expectedResult = { 7, 2, 1, 6, 8, 5, 3, 4 };

            CollectionAssert.AreEqual(expectedResult, list);
        }

        [TestMethod]
        public void testInvalidPatition_09()
        {
            MethodLibrary.MethodLibrary o = new MethodLibrary.MethodLibrary();
            int[] list = { 7, 2, 1, 6, 8, 5, 3, 4 };
            int left = 0;
            int right = 10;
            o.QuickSort(list, left, right);
            int[] expectedResult = { 7, 2, 1, 6, 8, 5, 3, 4 };

        CollectionAssert.AreEqual(expectedResult, list);
}

    // Invalid Boundary
    [TestMethod]
    public void testInvalidBoundary_10()
    {
        MethodLibrary.MethodLibrary o = new MethodLibrary.MethodLibrary();
        int[] list = { 7, 2, 1, 6, 8, 5, 3, 4 };
        int left = -1;
        int right = 2;
        o.QuickSort(list, left, right);
        int[] expectedResult = { 1, 2, 7, 6, 8, 5, 3, 4 };

        CollectionAssert.AreEqual(expectedResult, list);
    }

    [TestMethod]
    public void testInvalidBoundary_11()
    {
        MethodLibrary.MethodLibrary o = new MethodLibrary.MethodLibrary();
        int[] list = { 7, 2, 1, 6, 8, 5, 3, 4 };
        int left = 0;
        int right = -1;
        o.QuickSort(list, left, right);
        int[] expectedResult = { 7, 2, 1, 6, 8, 5, 3, 4 };

        CollectionAssert.AreEqual(expectedResult, list);
    }

    [TestMethod]
    public void testInvalidBoundary_12()
    {
        MethodLibrary.MethodLibrary o = new MethodLibrary.MethodLibrary();
        int[] list = { 7, 2, 1, 6, 8, 5, 3, 4 };
        int left = 0;
        int right = 8;
        o.QuickSort(list, left, right);
        int[] expectedResult = { 1,2,3,4,5,6,7,8 };

        CollectionAssert.AreEqual(expectedResult, list);
    }
}
}
