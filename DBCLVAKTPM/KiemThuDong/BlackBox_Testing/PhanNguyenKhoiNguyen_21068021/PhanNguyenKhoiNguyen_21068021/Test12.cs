using Microsoft.VisualStudio.TestTools.UnitTesting;
using System;

namespace PhanNguyenKhoiNguyen_21068021
{
    [TestClass]
    public class Test12
    {
        //Test for valid partition
        //1
        [TestMethod]
        public void testValidPartion_01()
        {
            MethodLibrary.MethodLibrary m = new MethodLibrary.MethodLibrary();
            int[] list = { 1, 2, 6, 9, 7, 8 };
            int actualResult = m.Largest(list);
            int expectedResult = 9;

            Assert.AreEqual(expectedResult, actualResult);
        }

        //2
        [TestMethod]
        public void testValidPartion_02()
        {
            MethodLibrary.MethodLibrary m = new MethodLibrary.MethodLibrary();
            int[] list = { };
            int actualResult = m.Largest(list);
            int expectedResult = 2147483647;

            Assert.AreEqual(expectedResult, actualResult);


        }
        //Test for valid boundary
        //3
        [TestMethod]
        public void testValidBoundary_03()
        {
            MethodLibrary.MethodLibrary m = new MethodLibrary.MethodLibrary();
            int[] list = { 1, 2, 2147483647, 4, 9 };
            int actualResult = m.Largest(list);
            int expectedResult = 2147483647;

            Assert.AreEqual(expectedResult, actualResult);


        }
        //4
        [TestMethod]
        public void testValidBoundary_04()
        {
            MethodLibrary.MethodLibrary m = new MethodLibrary.MethodLibrary();
            int[] list = { 1, 2, -2147483648, 4, 9 };
            int actualResult = m.Largest(list);
            int expectedResult = 9;

            Assert.AreEqual(expectedResult, actualResult);

        }
    }
}
