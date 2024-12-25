using Microsoft.VisualStudio.TestTools.UnitTesting;
using PhanNguyenKhoiNguyen_21068021_Module03;
using System;

namespace PhanNguyenKhoiNguyen_21068021_Test
{
    [TestClass]
    public class TestBai17
    {
        public TestContext TestContext { get; set; }

        [DataSource("Microsoft.VisualStudio.TestTools.DataSource.CSV",
        "|DataDirectory|\\dataBai17.csv", "dataBai17#csv", DataAccessMethod.Sequential),
        DeploymentItem("dataBai17.csv"), TestMethod()]
        public void testIsValidDate()
        {
            Module03 o = new Module03();
            short year = short.Parse(TestContext.DataRow[0].ToString());
            byte month = Byte.Parse(TestContext.DataRow[1].ToString());
            byte day = Byte.Parse(TestContext.DataRow[2].ToString());
            bool actualResult = o.IsValidDate(year, month, day);
            bool expectedResult = Boolean.Parse(TestContext.DataRow[3].ToString());
            Assert.AreEqual(expectedResult, actualResult);
        }
    }
}
