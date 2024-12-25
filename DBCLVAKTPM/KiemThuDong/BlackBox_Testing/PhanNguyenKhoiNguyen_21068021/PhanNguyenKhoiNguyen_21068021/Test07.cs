using Microsoft.VisualStudio.TestTools.UnitTesting;
using System;

namespace PhanNguyenKhoiNguyen_21068021
{
    [TestClass]
    public class Test07
    {
        [TestMethod]
        public void testValidPartition_01()
        {
            MethodLibrary.MethodLibrary m = new MethodLibrary.MethodLibrary();
            int a = 0;
            int b = 0;
            int c = 0;
            float x1,x2;

            String expectedResult = "Vô số nghiệm";

            String actualResult = m.SolveQuadratic(a, b, c, out x1, out x2);

            Assert.AreEqual(expectedResult, actualResult);
            Assert.IsTrue(float.IsNaN(x1)); // Kiểm tra x1 có phải là NaN không nếu là NaN thì trả về true
            Assert.IsTrue(float.IsNaN(x2));
        }

        [TestMethod]
        public void testValidPartition_02()
        {
            MethodLibrary.MethodLibrary m = new MethodLibrary.MethodLibrary();
            int a = 1;
            int b = 2;
            int c = 3;
            float x1, x2;

            String expectedResult = "Vô nghiệm";

            String actualResult = m.SolveQuadratic(a, b, c, out x1, out x2);

            Assert.AreEqual(expectedResult, actualResult);
            Assert.IsTrue(float.IsNaN(x1)); // Kiểm tra x1 có phải là NaN không nếu là NaN thì trả về true
            Assert.IsTrue(float.IsNaN(x2));
        }

        [TestMethod]
        public void testValidPartition_03()
        {
            MethodLibrary.MethodLibrary m = new MethodLibrary.MethodLibrary();
            int a = 0;
            int b = 0;
            int c = 5;
            float x1, x2;

            String expectedResult = "Vô nghiệm";

            String actualResult = m.SolveQuadratic(a, b, c, out x1, out x2);

            Assert.AreEqual(expectedResult, actualResult);
            Assert.IsTrue(float.IsNaN(x1)); // Kiểm tra x1 có phải là NaN không nếu là NaN thì trả về true
            Assert.IsTrue(float.IsNaN(x2));
        }

        [TestMethod]
        public void testValidPartition_04()
        {
            MethodLibrary.MethodLibrary m = new MethodLibrary.MethodLibrary();
            int a = 1;
            int b = 2;
            int c = 1;
            float x1, x2;

            String expectedResult = "Có nghiệm kép";

            String actualResult = m.SolveQuadratic(a, b, c, out x1, out x2);
            float expectedX1 = -1;
            float expectedX2 = -1;

            Assert.AreEqual(expectedResult, actualResult);
            Assert.AreEqual(expectedX1, x1, "x1 không đúng");
            Assert.AreEqual(expectedX2, x2, "x2 không đúng");
           
            

        }

        [TestMethod]
        public void testValidPartition_05()
        {
            MethodLibrary.MethodLibrary m = new MethodLibrary.MethodLibrary();
            int a = 0;
            int b = 3;
            int c = -6;
            float x1, x2;

            String expectedResult = "Có 1 nghiệm";

            String actualResult = m.SolveQuadratic(a, b, c, out x1, out x2);
            float expectedX1 = 2;
            float expectedX2 = 2;

            Assert.AreEqual(expectedResult, actualResult);
            Assert.AreEqual(expectedX1, x1);
            Assert.AreEqual(expectedX2, x2);
        }

        [TestMethod]
        public void testValidPartition_06()
        {
            MethodLibrary.MethodLibrary m = new MethodLibrary.MethodLibrary();
            int a = 1;
            int b = -3;
            int c = 2;
            float x1, x2;

            String expectedResult = "Có 2 nghiệm phân biệt";
            float expectedX1 = 2;
            float expectedX2 = 1;

            String actualResult = m.SolveQuadratic(a, b, c, out x1, out x2);
            

            Assert.AreEqual(expectedResult, actualResult);
            Assert.AreEqual(expectedX1, x1, "Giá trị x1 không chính xác");
            Assert.AreEqual(expectedX2, x2, "Giá trị x2 không chính xác");
           
           
        }
    }
}
