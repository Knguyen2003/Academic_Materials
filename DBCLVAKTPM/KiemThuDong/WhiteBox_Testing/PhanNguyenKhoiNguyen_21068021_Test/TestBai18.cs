using Microsoft.VisualStudio.TestTools.UnitTesting;
using PhanNguyenKhoiNguyen_21068021_Module03;
using System;

namespace PhanNguyenKhoiNguyen_21068021_Test
{
    [TestClass]
    public class TestBai18
    {
        public TestContext TestContext { get; set; }

        [DataSource("Microsoft.VisualStudio.TestTools.DataSource.CSV",
        "|DataDirectory|\\dataBai18.csv", "dataBai18#csv", DataAccessMethod.Sequential),
        DeploymentItem("dataBai18.csv"), TestMethod()]
        public void testEmailCheck()
        {
            Module03 o = new Module03();
            String email = TestContext.DataRow[0].ToString();
            bool actualResult = o.EmailCheck(email);
            bool expectedResult = Boolean.Parse(TestContext.DataRow[1].ToString());
            Assert.AreEqual(expectedResult, actualResult);
        }
    }
}
