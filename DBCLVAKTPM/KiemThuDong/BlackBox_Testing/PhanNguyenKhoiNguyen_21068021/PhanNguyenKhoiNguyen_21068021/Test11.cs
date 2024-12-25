using Microsoft.VisualStudio.TestTools.UnitTesting;
using System;

namespace PhanNguyenKhoiNguyen_21068021
{
    [TestClass]
    public class Test11
    {
        [TestMethod]
        public void testValidPartition_01()
        {
            MethodLibrary.MethodLibrary o = new MethodLibrary.MethodLibrary();
            String s1= "truong dh cong nghiep";
            String s2 = "dh";
            String s3 = "dai hoc";

            String expectedResult = "truong dai hoc cong nghiep";
            String actualResult = o.ThayThe(s1, s2, s3);
            Assert.AreEqual(expectedResult, actualResult);

        }

        [TestMethod]
        public void testValidPartition_02()
        {
            MethodLibrary.MethodLibrary o = new MethodLibrary.MethodLibrary();
            String s1 = "truong dh cong nghiep";
            String s2 = "sfd";
            String s3 = "dai hoc";

            String expectedResult = "truong dh cong nghiep";
            String actualResult = o.ThayThe(s1, s2, s3);
            Assert.AreEqual(expectedResult, actualResult);
        }

        [TestMethod]
        public void testValidPartition_03()
        {
            MethodLibrary.MethodLibrary o = new MethodLibrary.MethodLibrary();
            String s1 = "";
            String s2 = "";
            String s3 = "";

            String expectedResult = "";
            String actualResult = o.ThayThe(s1, s2, s3);
            Assert.AreEqual(expectedResult, actualResult);
        }

        [TestMethod]
        public void testValidBoundary_04()
        {
            MethodLibrary.MethodLibrary o = new MethodLibrary.MethodLibrary();
            String s1 = "dh cong nghiep";
            String s2 = "dh";
            String s3 = "dai hoc";

            String expectedResult = "dai hoc cong nghiep";
            String actualResult = o.ThayThe(s1, s2, s3);
            Assert.AreEqual(expectedResult, actualResult);
        }

        [TestMethod]
        public void testValidBoundary_05()
        {
            MethodLibrary.MethodLibrary o = new MethodLibrary.MethodLibrary();
            String s1 = "truong dh cn";
            String s2 = "cn";
            String s3 = "cong nghiep";

            String expectedResult = "truong dh cong nghiep";
            String actualResult = o.ThayThe(s1, s2, s3);
            Assert.AreEqual(expectedResult, actualResult);
        }


        [TestMethod]
        public void testInvalidPartition_06()
        {
            MethodLibrary.MethodLibrary o = new MethodLibrary.MethodLibrary();
            String s1 = "";
            String s2 = "dh";
            String s3 = "dai hoc";

            String expectedResult = "Chuỗi s1 không được rỗng";
            String actualResult = o.ThayThe(s1, s2, s3);
            Assert.AreEqual(expectedResult, actualResult);
        }

        [TestMethod]
        public void testInvalidPartition_07()
        {
            MethodLibrary.MethodLibrary o = new MethodLibrary.MethodLibrary();
            String s1 = "truong dh cong nghiep";
            String s2 = "";
            String s3 = "dai hoc";

            String expectedResult = "truong dh cong nghiep";
            String actualResult = o.ThayThe(s1, s2, s3);
            Assert.AreEqual(expectedResult, actualResult);
        }

        [TestMethod]
        public void testInvalidPartition_08()
        {
            MethodLibrary.MethodLibrary o = new MethodLibrary.MethodLibrary();
            String s1 = "truong dh cong nghiep";
            String s2 = "dh";
            String s3 = "";

            String expectedResult = "truong  cong nghiep";
            String actualResult = o.ThayThe(s1, s2, s3);
            Assert.AreEqual(expectedResult, actualResult);
        }
    }

}
