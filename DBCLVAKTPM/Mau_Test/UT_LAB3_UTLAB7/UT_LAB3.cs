using Microsoft.VisualStudio.TestTools.UnitTesting;
using System;

namespace PhanNguyenKhoiNguyen_21068021
{
    [TestClass]
    public class UT_LAB3
    {

        // Test for valid partition
        
        //1
        [TestMethod]
        public void testValidPartition_1()
        {
            MethodLibrary.MethodLibrary m = new MethodLibrary.MethodLibrary();
            double actualResult = m.TinhTienDien(20, 50);
            double expectedResult = 48972;

            double delta = 0.01; //cho phep sai so
            Assert.AreEqual(expectedResult, actualResult,delta);
        }
        //2
        [TestMethod]
        public void testValidPartition_2()
        {
            MethodLibrary.MethodLibrary m = new MethodLibrary.MethodLibrary();
            double actualResult = m.TinhTienDien(30, 100);
            double expectedResult = 115346;

            double delta = 0.01;

            Assert.AreEqual(expectedResult, actualResult,delta);
        }

        //3
        [TestMethod]
        public void testValidPartition_3()
        {
            MethodLibrary.MethodLibrary m = new MethodLibrary.MethodLibrary();
            double actualResult = m.TinhTienDien(100, 250);
            double expectedResult = 264165;

            Assert.AreEqual(expectedResult, actualResult);
        }

        //4
        [TestMethod]
        public void testValidPartition_4()
        {
            MethodLibrary.MethodLibrary m = new MethodLibrary.MethodLibrary();
            double actualResult = m.TinhTienDien(40, 300);
            double expectedResult = 510367;

            double delta = 0.01;
            Assert.AreEqual(expectedResult, actualResult,delta);
        }
        //5
        [TestMethod]
        public void testValidPartition_5()
        {
            MethodLibrary.MethodLibrary m = new MethodLibrary.MethodLibrary();
            double actualResult = m.TinhTienDien(70, 450);
            double expectedResult = 829279;

            double delta = 0.01;
            Assert.AreEqual(expectedResult, actualResult,delta);
        }


        //6
        [TestMethod]
        public void testValidPartition_6()
        {
            MethodLibrary.MethodLibrary m = new MethodLibrary.MethodLibrary();
            double actualResult = m.TinhTienDien(60, 550);
            double expectedResult = 1140458;

            double delta = 0.01;
            Assert.AreEqual(expectedResult, actualResult,delta);
        }


        //Test for valid boundary

        //7
        [TestMethod]
        public void testValidBoundary_7()
        {
            MethodLibrary.MethodLibrary m = new MethodLibrary.MethodLibrary();
            double actualResult = m.TinhTienDien(0, 0);
            double expectedResult = 0;

            double delta = 0.01;
            Assert.AreEqual(expectedResult, actualResult, delta);
        }

        //8
        [TestMethod]
        public void testValidBoundary_8()
        {
            MethodLibrary.MethodLibrary m = new MethodLibrary.MethodLibrary();
            double actualResult = m.TinhTienDien(50, 100);
            double expectedResult = 81620;

            double delta = 0.01;
            Assert.AreEqual(expectedResult, actualResult, delta);
        }

        //9
        [TestMethod]
        public void testValidBoundary_9()
        {
            MethodLibrary.MethodLibrary m = new MethodLibrary.MethodLibrary();
            double actualResult = m.TinhTienDien(49, 100);
            double expectedResult = 83306.3;

            Assert.AreEqual(expectedResult, actualResult);
        }

        //10
        [TestMethod]
        public void testValidBoundary_10()
        {
            MethodLibrary.MethodLibrary m = new MethodLibrary.MethodLibrary();
            double actualResult = m.TinhTienDien(100, 200);
            double expectedResult = 165935;

            Assert.AreEqual(expectedResult, actualResult);
        }

        //11
        [TestMethod]
        public void testValidBoundary_11()
        {
            MethodLibrary.MethodLibrary m = new MethodLibrary.MethodLibrary();
            double actualResult = m.TinhTienDien(99, 200);
            double expectedResult = 167899.6;

            Assert.AreEqual(expectedResult, actualResult);
        }

        //12
        [TestMethod]
        public void testValidBoundary_12()
        {
            MethodLibrary.MethodLibrary m = new MethodLibrary.MethodLibrary();
            double actualResult = m.TinhTienDien(200, 400);
            double expectedResult = 362395;

            double delta = 0.01;
            Assert.AreEqual(expectedResult, actualResult, delta);
        }

        //13
        [TestMethod]
        public void testValidBoundary_13()
        {
            MethodLibrary.MethodLibrary m = new MethodLibrary.MethodLibrary();
            double actualResult = m.TinhTienDien(99, 300);
            double expectedResult = 364861.2;

            double delta = 0.01;
            Assert.AreEqual(expectedResult, actualResult, delta);
        }

        //14
        [TestMethod]
        public void testValidBoundary_14()
        {
            MethodLibrary.MethodLibrary m = new MethodLibrary.MethodLibrary();
            double actualResult = m.TinhTienDien(100, 400);
            double expectedResult = 609015;

            double delta = 0.01;
            Assert.AreEqual(expectedResult, actualResult, delta);
        }

        //15
        [TestMethod]
        public void testValidBoundary_15()
        {
            MethodLibrary.MethodLibrary m = new MethodLibrary.MethodLibrary();
            double actualResult = m.TinhTienDien(99, 400);
            double expectedResult = 611768.3;

            double delta = 0.01;
            Assert.AreEqual(expectedResult, actualResult, delta);
        }

        //16
        [TestMethod]
        public void testValidBoundary_16()
        {
            MethodLibrary.MethodLibrary m = new MethodLibrary.MethodLibrary();
            double actualResult = m.TinhTienDien(100, 500);
            double expectedResult = 884345;

            double delta = 0.01;
            Assert.AreEqual(expectedResult, actualResult, delta);
        }


        //17
        [TestMethod]
        public void testValidBoundary_17()
        {
            MethodLibrary.MethodLibrary m = new MethodLibrary.MethodLibrary();
            double actualResult = m.TinhTienDien(99, 500);
            double expectedResult = 887190.7;

            double delta = 0.01;
            Assert.AreEqual(expectedResult, actualResult, delta);
        }

        //Test for invalid partition


        //18
        [TestMethod]
        public void testInvalidPartition_18()
        {
            MethodLibrary.MethodLibrary m = new MethodLibrary.MethodLibrary();
            double actualResult = m.TinhTienDien(-364, 100);
            double expectedResult = -1;

            Assert.AreEqual(expectedResult, actualResult);
        }


        //19
        [TestMethod]
        public void testInvalidPartition_19()
        {
            MethodLibrary.MethodLibrary m = new MethodLibrary.MethodLibrary();
            double actualResult = m.TinhTienDien(150, 100);
            double expectedResult = -1;

            Assert.AreEqual(expectedResult, actualResult);
        }


        //Test for invalid boundary

        //20
        [TestMethod]
        public void testInvalidBoundary_20()
        {
            MethodLibrary.MethodLibrary m = new MethodLibrary.MethodLibrary();
            double actualResult = m.TinhTienDien(-1, 100);
            double expectedResult = -1;

            Assert.AreEqual(expectedResult, actualResult);
        }

        //21
        [TestMethod]
        public void testInvalidBoundary_21()
        {
            MethodLibrary.MethodLibrary m = new MethodLibrary.MethodLibrary();
            double actualResult = m.TinhTienDien(101, 100);
            double expectedResult = -1;

            Assert.AreEqual(expectedResult, actualResult);
        }
    }
}
