using Microsoft.VisualStudio.TestTools.UnitTesting;
using PhanNguyenKhoiNguyen_21068021_Module03;
using System;

namespace PhanNguyenKhoiNguyen_21068021_Test
{
    [TestClass]
    public class TestBai07
    {
        public TestContext TestContext { get; set; }

        [DataSource("Microsoft.VisualStudio.TestTools.DataSource.CSV",
        "|DataDirectory|\\dataBai07.csv", "dataBai07#csv", DataAccessMethod.Sequential),
        DeploymentItem("dataBai07.csv"), TestMethod()]
        public void testDayinMonth()
        {
            Module03 m = new Module03();
            byte month = Byte.Parse(TestContext.DataRow[0].ToString());
            ushort year = ushort.Parse(TestContext.DataRow[1].ToString());
            Byte expected = Byte.Parse(TestContext.DataRow[2].ToString());

            Byte actual = m.DayinMonth(month, year);
            Assert.AreEqual(expected, actual);
        }
    }
}
