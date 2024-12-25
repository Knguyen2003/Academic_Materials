using Microsoft.VisualStudio.TestTools.UnitTesting;
using PhanNguyenKhoiNguyen_21068021_Module03;
using System;

namespace PhanNguyenKhoiNguyen_21068021_Test
{
    [TestClass]
    public class TestBai04
    {
        public TestContext TestContext { get; set; }

        [DataSource("Microsoft.VisualStudio.TestTools.DataSource.CSV",
        "|DataDirectory|\\dataBai04.csv", "dataBai04#csv", DataAccessMethod.Sequential),
        DeploymentItem("dataBai04.csv"), TestMethod()]
        public void testMax()
        {
            Module03 m = new Module03();
            int a = Int32.Parse(TestContext.DataRow[0].ToString());
            int b = Int32.Parse(TestContext.DataRow[1].ToString());
            int c = Int32.Parse(TestContext.DataRow[2].ToString());
            int actualResult = m.Max(a, b, c);
            int expectedResult = Int32.Parse(TestContext.DataRow[3].ToString());
            Assert.AreEqual(expectedResult, actualResult);
        }
    }
}
