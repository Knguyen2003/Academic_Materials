using Microsoft.VisualStudio.TestTools.UnitTesting;
using System;

namespace PhanNguyenKhoiNguyen_21068021
{
    [TestClass]
    public class TestDataDriven11
    {
        public TestContext TestContext { get; set; }

        [DataSource("Microsoft.VisualStudio.TestTools.DataSource.CSV",
        "|DataDirectory|\\data_11.csv", "data_11#csv", DataAccessMethod.Sequential),
        DeploymentItem("data_11.csv"), TestMethod()]
        public void testDataDriven11()
        {
            MethodLibrary.MethodLibrary o = new MethodLibrary.MethodLibrary();
            String s1 = TestContext.DataRow[0].ToString();
            String s2 = TestContext.DataRow[1].ToString();
            String s3 = TestContext.DataRow[2].ToString();

            String expectedResult = TestContext.DataRow[3].ToString();
            String actualResult = o.ThayThe(s1, s2, s3);
            Assert.AreEqual(expectedResult, actualResult);
        }
    }
}
