using Microsoft.VisualStudio.TestTools.UnitTesting;
using System;

namespace PhanNguyenKhoiNguyen_21068021
{
    [TestClass]
    public class Test06
    {
        [TestMethod]
        public void testValidPartition_01()
        {
            MethodLibrary.MethodLibrary m = new MethodLibrary.MethodLibrary();
            int a = 5;
            int b = 9;
            int c = 10;

            String expectedResult = "Scalene";
            String actualResult = m.Triangle(a,b,c);
            Assert.AreEqual(expectedResult, actualResult);
        }

        [TestMethod]
        public void testValidPartition_02()
        {
            MethodLibrary.MethodLibrary m = new MethodLibrary.MethodLibrary();
            int a = 5;
            int b = 5;
            int c = 8;

            String expectedResult = "Isosceles";
            String actualResult = m.Triangle(a, b, c);
            Assert.AreEqual(expectedResult, actualResult);
        }

        [TestMethod]
        public void testValidPartition_03()
        {
            MethodLibrary.MethodLibrary m = new MethodLibrary.MethodLibrary();
            int a = 5;
            int b = 9;
            int c = 5;

            String expectedResult = "Isosceles";
            String actualResult = m.Triangle(a, b, c);
            Assert.AreEqual(expectedResult, actualResult);
        }

        [TestMethod]
        public void testValidPartition_04()
        {
            MethodLibrary.MethodLibrary m = new MethodLibrary.MethodLibrary();
            int a = 5;
            int b = 9;
            int c = 9;

            String expectedResult = "Isosceles";
            String actualResult = m.Triangle(a, b, c);
            Assert.AreEqual(expectedResult, actualResult);
        }


        [TestMethod]
        public void testValidPartition_05()
        {
            MethodLibrary.MethodLibrary m = new MethodLibrary.MethodLibrary();
            int a = 5;
            int b = 5;
            int c = 5;

            String expectedResult = "Equilateral";
            String actualResult = m.Triangle(a, b, c);
            Assert.AreEqual(expectedResult, actualResult);
        }




        [TestMethod]
        public void testValidBoundary_06()
        {
            MethodLibrary.MethodLibrary m = new MethodLibrary.MethodLibrary();
            int a = 1;
            int b = 1;
            int c = 1;

            String expectedResult = "Equilateral";
            String actualResult = m.Triangle(a, b, c);
            Assert.AreEqual(expectedResult, actualResult);
        }


        [TestMethod]
        public void testValidBoundary_07()
        {
            MethodLibrary.MethodLibrary m = new MethodLibrary.MethodLibrary();
            int a = 2;
            int b = 5;
            int c = 6;

            String expectedResult = "Scalene";
            String actualResult = m.Triangle(a, b, c);
            Assert.AreEqual(expectedResult, actualResult);
        }


        [TestMethod]
        public void testValidBoundary_08()
        {
            MethodLibrary.MethodLibrary m = new MethodLibrary.MethodLibrary();
            int a = 2;
            int b = 6;
            int c = 5;

            String expectedResult = "Scalene";
            String actualResult = m.Triangle(a, b, c);
            Assert.AreEqual(expectedResult, actualResult);
        }


        [TestMethod]
        public void testValidBoundary_09()
        {
            MethodLibrary.MethodLibrary m = new MethodLibrary.MethodLibrary();
            int a = 6;
            int b = 2;
            int c = 5;

            String expectedResult = "Scalene";
            String actualResult = m.Triangle(a, b, c);
            Assert.AreEqual(expectedResult, actualResult);
        }


        //Test invalid partition
        [TestMethod]
        public void testInvalidPartition_10()
        {
            MethodLibrary.MethodLibrary m = new MethodLibrary.MethodLibrary();
            int a = -6;
            int b = 9;
            int c = 10;

            String expectedResult = "";
            String actualResult = m.Triangle(a, b, c);
            Assert.AreEqual(expectedResult, actualResult);
        }

        [TestMethod]
        public void testInvalidPartition_11()
        {
            MethodLibrary.MethodLibrary m = new MethodLibrary.MethodLibrary();
            int a = 5;
            int b = -8;
            int c = 10;

            String expectedResult = "";
            String actualResult = m.Triangle(a, b, c);
            Assert.AreEqual(expectedResult, actualResult);
        }

        [TestMethod]
        public void testInvalidPartition_12()
        {
            MethodLibrary.MethodLibrary m = new MethodLibrary.MethodLibrary();
            int a = 5;
            int b = 9;
            int c = -56;

            String expectedResult = "";
            String actualResult = m.Triangle(a, b, c);
            Assert.AreEqual(expectedResult, actualResult);
        }

        [TestMethod]
        public void testInvalidPartition_13()
        {
            MethodLibrary.MethodLibrary m = new MethodLibrary.MethodLibrary();
            int a = 2;
            int b = 6;
            int c = 13;

            String expectedResult = "";
            String actualResult = m.Triangle(a, b, c);
            Assert.AreEqual(expectedResult, actualResult);
        }

        [TestMethod]
        public void testInvalidPartition_14()
        {
            MethodLibrary.MethodLibrary m = new MethodLibrary.MethodLibrary();
            int a = 5;
            int b = 15;
            int c = 6;

            String expectedResult = "";
            String actualResult = m.Triangle(a, b, c);
            Assert.AreEqual(expectedResult, actualResult);
        }


        [TestMethod]
        public void testInvalidPartition_15()
        {
            MethodLibrary.MethodLibrary m = new MethodLibrary.MethodLibrary();
            int a = 15;
            int b = 6;
            int c = 5;

            String expectedResult = "";
            String actualResult = m.Triangle(a, b, c);
            Assert.AreEqual(expectedResult, actualResult);
        }

        //For invalid boundary
        [TestMethod]
        public void testInvalidBoundary_16()
        {
            MethodLibrary.MethodLibrary m = new MethodLibrary.MethodLibrary();
            int a = 0;
            int b = 9;
            int c = 10;

            String expectedResult = "";
            String actualResult = m.Triangle(a, b, c);
            Assert.AreEqual(expectedResult, actualResult);
        }

        [TestMethod]
        public void testInvalidBoundary_17()
        {
            MethodLibrary.MethodLibrary m = new MethodLibrary.MethodLibrary();
            int a = 5;
            int b = 0;
            int c = 10;

            String expectedResult = "";
            String actualResult = m.Triangle(a, b, c);
            Assert.AreEqual(expectedResult, actualResult);
        }

        [TestMethod]
        public void testInvalidBoundary_18()
        {
            MethodLibrary.MethodLibrary m = new MethodLibrary.MethodLibrary();
            int a = 5;
            int b = 9;
            int c = 0;

            String expectedResult = "";
            String actualResult = m.Triangle(a, b, c);
            Assert.AreEqual(expectedResult, actualResult);
        }


        [TestMethod]
        public void testInvalidBoundary_19()
        {
            MethodLibrary.MethodLibrary m = new MethodLibrary.MethodLibrary();
            int a = 5;
            int b = 9;
            int c = 14;

            String expectedResult = "";
            String actualResult = m.Triangle(a, b, c);
            Assert.AreEqual(expectedResult, actualResult);
        }

        [TestMethod]
        public void testInvalidBoundary_20()
        {
            MethodLibrary.MethodLibrary m = new MethodLibrary.MethodLibrary();
            int a = 5;
            int b = 13;
            int c = 8;

            String expectedResult = "";
            String actualResult = m.Triangle(a, b, c);
            Assert.AreEqual(expectedResult, actualResult);
        }

        [TestMethod]
        public void testInvalidBoundary_21()
        {
            MethodLibrary.MethodLibrary m = new MethodLibrary.MethodLibrary();
            int a = 10;
            int b = 9;
            int c = 1;

            String expectedResult = "";
            String actualResult = m.Triangle(a, b, c);
            Assert.AreEqual(expectedResult, actualResult);
        }

    }
}
