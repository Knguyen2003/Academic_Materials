using Microsoft.VisualStudio.TestTools.UnitTesting;
using PhanNguyenKhoiNguyen_21068021_Module03;
using System;

namespace PhanNguyenKhoiNguyen_21068021_Test
{
    [TestClass]
    public class TestBai15
    {
        public TestContext TestContext { get; set; }

        [DataSource("Microsoft.VisualStudio.TestTools.DataSource.CSV",
        "|DataDirectory|\\dataBai15.csv", "dataBai15#csv", DataAccessMethod.Sequential),
        DeploymentItem("dataBai15.csv"), TestMethod()]
        public void testCheckYear()
        {
            Module03 o = new Module03();
            int year = Int32.Parse(TestContext.DataRow[0].ToString());
            bool actualResult = o.checkYear(year);
            bool expectedResult = Boolean.Parse(TestContext.DataRow[1].ToString());
            Assert.AreEqual(expectedResult, actualResult);
        }
    }
}
