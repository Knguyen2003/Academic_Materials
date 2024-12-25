using Microsoft.VisualStudio.TestTools.UnitTesting;
using System;

namespace PhanNguyenKhoiNguyen_21068021
{
    [TestClass]
    public class Test10
    {
        //Test valid partition
        [TestMethod]
        public void testValidPartition_01()
        {
            MethodLibrary.MethodLibrary o = new MethodLibrary.MethodLibrary();
            String s = "123456789";
            int n = 2;
            int p = 5;

            String expectedResult = "1234789";

            String actualResult = o.HuyChuoi(s, n, p);

            Assert.AreEqual(expectedResult, actualResult);

        }
        //Test valid boundary
        [TestMethod]
        public void testValidBoundary_02()
        {
            MethodLibrary.MethodLibrary o = new MethodLibrary.MethodLibrary();
            String s = "123456789";
            int n = 0;
            int p = 0;

            String expectedResult = "123456789";

            String actualResult = o.HuyChuoi(s, n, p);

            Assert.AreEqual(expectedResult, actualResult);

        }
        [TestMethod]
        public void testValidBoundary_03()
        {
            MethodLibrary.MethodLibrary o = new MethodLibrary.MethodLibrary();
            String s = "123456789";
            int n = 1;
            int p = 8;

            String expectedResult = "12345679";

            String actualResult = o.HuyChuoi(s, n, p);

            Assert.AreEqual(expectedResult, actualResult);

        }
        //Test invalid partition

        [TestMethod]
        public void testInvalidPartion_04()
        {
            MethodLibrary.MethodLibrary o = new MethodLibrary.MethodLibrary();
            String s = "";
            int n = 2;
            int p = 5;

            String expectedResult = "";

            String actualResult = o.HuyChuoi(s, n, p);

            Assert.AreEqual(expectedResult, actualResult);
        }

        [TestMethod]
        public void testInvalidPartion_05()
        {
            MethodLibrary.MethodLibrary o = new MethodLibrary.MethodLibrary();
            String s = "123456789";
            int n = -6;
            int p = 5;

            String expectedResult = "123456789";

            String actualResult = o.HuyChuoi(s, n, p);

            Assert.AreEqual(expectedResult, actualResult);
        }

        [TestMethod]
        public void testInvalidPartion_06()
        {
            MethodLibrary.MethodLibrary o = new MethodLibrary.MethodLibrary();
            String s = "123456789";
            int n = 7;
            int p = 5;

            String expectedResult = "1234";

            String actualResult = o.HuyChuoi(s, n, p);

            Assert.AreEqual(expectedResult, actualResult);
        }

        [TestMethod]
        public void testInvalidPartion_07()
        {
            MethodLibrary.MethodLibrary o = new MethodLibrary.MethodLibrary();
            String s = "123456789";
            int n = 2;
            int p = -3;

            String expectedResult = "123456789";

            String actualResult = o.HuyChuoi(s, n, p);

            Assert.AreEqual(expectedResult, actualResult);
        }

        [TestMethod]
        public void testInvalidPartion_08()
        {
            MethodLibrary.MethodLibrary o = new MethodLibrary.MethodLibrary();
            String s = "123456789";
            int n = 2;
            int p = 10;

            String expectedResult = "123456789";

            String actualResult = o.HuyChuoi(s, n, p);

            Assert.AreEqual(expectedResult, actualResult);
        }
        //Test invalid boundary
        [TestMethod]
        public void testInvalidBoundary_09()
        {
            MethodLibrary.MethodLibrary o = new MethodLibrary.MethodLibrary();
            String s = "123456789";
            int n = -1;
            int p = 5;

            String expectedResult = "123456789";

            String actualResult = o.HuyChuoi(s, n, p);

            Assert.AreEqual(expectedResult, actualResult);
        }

        [TestMethod]
        public void testInvalidBoundary_10()
        {
            MethodLibrary.MethodLibrary o = new MethodLibrary.MethodLibrary();
            String s = "123456789";
            int n = 5;
            int p = 5;

            String expectedResult = "1234";

            String actualResult = o.HuyChuoi(s, n, p);

            Assert.AreEqual(expectedResult, actualResult);
        }


        [TestMethod]
        public void testInvalidBoundary_11()
        {
            MethodLibrary.MethodLibrary o = new MethodLibrary.MethodLibrary();
            String s = "123456789";
            int n = 2;
            int p = -1;

            String expectedResult = "123456789";

            String actualResult = o.HuyChuoi(s, n, p);

            Assert.AreEqual(expectedResult, actualResult);
        }

        [TestMethod]
        public void testInvalidBoundary_12()
        {
            MethodLibrary.MethodLibrary o = new MethodLibrary.MethodLibrary();
            String s = "123456789";
            int n = 2;
            int p = 9;

            String expectedResult = "12345678";

            String actualResult = o.HuyChuoi(s, n, p);

            Assert.AreEqual(expectedResult, actualResult);
        }


    }
}
