using Microsoft.VisualStudio.TestTools.UnitTesting;
using PhanNguyenKhoiNguyen_21068021_Module03;
using System;

namespace PhanNguyenKhoiNguyen_21068021_Test
{
    [TestClass]
    public class TestBai01
    {
        public TestContext TestContext { get; set; }

        [DataSource("Microsoft.VisualStudio.TestTools.DataSource.CSV",
        "|DataDirectory|\\dataBai01.csv", "dataBai01#csv", DataAccessMethod.Sequential),
        DeploymentItem("dataBai01.csv"), TestMethod()]
        public void testBai01()
        {
            Module03 o = new Module03();
            int firstRadius = Int32.Parse(TestContext.DataRow[1].ToString());
            int secRadius = Int32.Parse(TestContext.DataRow[2].ToString());
            int distance = Int32.Parse(TestContext.DataRow[0].ToString());

            int actualResult = o.GetPositionOf2Cir(firstRadius, secRadius, distance);
            int expectedResult = Int32.Parse(TestContext.DataRow[3].ToString());
            Assert.AreEqual(expectedResult, actualResult);
        }
    }
}
