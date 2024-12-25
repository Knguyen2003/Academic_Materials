using Microsoft.VisualStudio.TestTools.UnitTesting;
using PhanNguyenKhoiNguyen_21068021_Module03;
using System;

namespace PhanNguyenKhoiNguyen_21068021_Test
{
    [TestClass]
    public class TestBai10
    {
        public TestContext TestContext { get; set; }

        [DataSource("Microsoft.VisualStudio.TestTools.DataSource.CSV",
        "|DataDirectory|\\dataBai10.csv", "dataBai10#csv", DataAccessMethod.Sequential),
        DeploymentItem("dataBai10.csv"), TestMethod()]
        public void testBai10()
        {
            Module03 m = new Module03();
            int a = Int32.Parse(TestContext.DataRow[0].ToString());
            int b = Int32.Parse(TestContext.DataRow[1].ToString());
            int c = Int32.Parse(TestContext.DataRow[2].ToString());

            bool expectedResult = Boolean.Parse(TestContext.DataRow[3].ToString());

            bool actualResult = m.bai10(a, b, c);
            Assert.AreEqual(expectedResult, actualResult);
        }
    }
}
