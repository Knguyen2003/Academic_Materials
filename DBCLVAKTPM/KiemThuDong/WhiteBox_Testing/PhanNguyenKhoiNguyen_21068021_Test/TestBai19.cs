using Microsoft.VisualStudio.TestTools.UnitTesting;
using PhanNguyenKhoiNguyen_21068021_Module03;
using System;

namespace PhanNguyenKhoiNguyen_21068021_Test
{
    [TestClass]
    public class TestBai19
    {
        public TestContext TestContext { get; set; }

        [DataSource("Microsoft.VisualStudio.TestTools.DataSource.CSV",
        "|DataDirectory|\\dataBai19.csv", "dataBai19#csv", DataAccessMethod.Sequential),
        DeploymentItem("dataBai19.csv"), TestMethod()]

        public void TestBodyCheck()
        {
            Module03 o = new Module03();
            short height = short.Parse(TestContext.DataRow[0].ToString());
            int weight = Int32.Parse(TestContext.DataRow[1].ToString());
            int actualResult = o.BodyCheck(height, weight);
            int expectedResult = Int32.Parse(TestContext.DataRow[2].ToString());

            Assert.AreEqual(expectedResult, actualResult);
        }
    }
}
