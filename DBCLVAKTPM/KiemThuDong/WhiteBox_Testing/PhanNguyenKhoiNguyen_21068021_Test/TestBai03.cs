using Microsoft.VisualStudio.TestTools.UnitTesting;
using PhanNguyenKhoiNguyen_21068021_Module03;
using System;

namespace PhanNguyenKhoiNguyen_21068021_Test
{
    [TestClass]
    public class TestBai03
    {
        public TestContext TestContext { get; set; }

        [DataSource("Microsoft.VisualStudio.TestTools.DataSource.CSV",
        "|DataDirectory|\\dataBai03.csv", "dataBai03#csv", DataAccessMethod.Sequential),
        DeploymentItem("dataBai03.csv"), TestMethod()]
        public void TestMethod1()
        {

            Module03 m = new Module03();
            double mean;
            int a = Int32.Parse(TestContext.DataRow[0].ToString());
            int b = Int32.Parse(TestContext.DataRow[1].ToString());
            int c = Int32.Parse(TestContext.DataRow[2].ToString());
            int actualResult = m.MaxAndMean(a, b, c, out mean);
            int expectedResult = Int32.Parse(TestContext.DataRow[3].ToString());

            double expectedMean = Double.Parse(TestContext.DataRow[4].ToString());
            Assert.AreEqual(expectedResult, actualResult);
            Assert.AreEqual(expectedMean, mean);
        }

    }
}
