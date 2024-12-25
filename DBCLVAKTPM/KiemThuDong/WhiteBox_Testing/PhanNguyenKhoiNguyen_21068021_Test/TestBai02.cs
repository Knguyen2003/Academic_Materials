using Microsoft.VisualStudio.TestTools.UnitTesting;
using PhanNguyenKhoiNguyen_21068021_Module03;
using System;

namespace PhanNguyenKhoiNguyen_21068021_Test
{
    [TestClass]
    public class TestBai02
    {
        public TestContext TestContext { get; set; }

        [DataSource("Microsoft.VisualStudio.TestTools.DataSource.CSV",
        "|DataDirectory|\\dataBai02.csv", "dataBai02#csv", DataAccessMethod.Sequential),
        DeploymentItem("dataBai02.csv"), TestMethod()]
        public void testBai02()
        {
            Module03 o = new Module03();
            int X = Int32.Parse(TestContext.DataRow[0].ToString());
            int Y = Int32.Parse(TestContext.DataRow[1].ToString());
            int Z = Int32.Parse(TestContext.DataRow[2].ToString());
            String actualResult = o.bai02(X, Y, Z);
            String expectedResult = TestContext.DataRow[3].ToString();

            Assert.AreEqual(expectedResult, actualResult);
        }
    }
}
