using Microsoft.VisualStudio.TestTools.UnitTesting;
using PhanNguyenKhoiNguyen_21068021_Module03;
using System;

namespace PhanNguyenKhoiNguyen_21068021_Test
{
    [TestClass]
    public class TestBai16
    {
        public TestContext TestContext { get; set; }

        [DataSource("Microsoft.VisualStudio.TestTools.DataSource.CSV",
        "|DataDirectory|\\dataBai16.csv", "dataBai16#csv", DataAccessMethod.Sequential),
        DeploymentItem("dataBai16.csv"), TestMethod()]
        public void testPasswordCheck()
        {
            Module03 o = new Module03();
            String pass = TestContext.DataRow[0].ToString();
            bool actualResult = o.PasswordCheck(pass);
            bool expectedResult = Boolean.Parse(TestContext.DataRow[1].ToString());
            Assert.AreEqual(expectedResult, actualResult);
        }
    }
}
