using Microsoft.VisualStudio.TestTools.UnitTesting;
using PhanNguyenKhoiNguyen_21068021_Module03;
using System;

namespace PhanNguyenKhoiNguyen_21068021_Test
{
    [TestClass]
    public class TestBai20
    {
        public TestContext TestContext { get; set; }

        [DataSource("Microsoft.VisualStudio.TestTools.DataSource.CSV",
        "|DataDirectory|\\dataBai20.csv", "dataBai20#csv", DataAccessMethod.Sequential),
        DeploymentItem("dataBai20.csv"), TestMethod()]
        public void testisInString()
        {
            Module03 o = new Module03();
            char tmp = char.Parse(TestContext.DataRow[0].ToString());
            int actualResult = o.isInString(tmp);
            int expectedResult = Int32.Parse(TestContext.DataRow[1].ToString());
            Assert.AreEqual(expectedResult, actualResult);
        }
    }
}
