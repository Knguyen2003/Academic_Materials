using Microsoft.VisualStudio.TestTools.UnitTesting;
using PhanNguyenKhoiNguyen_21068021_Module03;
using System;

namespace PhanNguyenKhoiNguyen_21068021_Test
{
    [TestClass]
    public class TestBai21
    {
        public TestContext TestContext { get; set; }

        [DataSource("Microsoft.VisualStudio.TestTools.DataSource.CSV",
        "|DataDirectory|\\dataBai21.csv", "dataBai21#csv", DataAccessMethod.Sequential),
        DeploymentItem("dataBai21.csv"), TestMethod()]
        public void testHexToDec()
        {
            Module03 o = new Module03();
            String hexaString = TestContext.DataRow[0].ToString();
            long actualResult = o.HexToDec(hexaString);
            long expectedResult = long.Parse(TestContext.DataRow[1].ToString());
            Assert.AreEqual(expectedResult, actualResult);
        }
    }
}
