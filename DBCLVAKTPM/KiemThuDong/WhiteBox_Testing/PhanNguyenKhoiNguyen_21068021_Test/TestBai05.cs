using Microsoft.VisualStudio.TestTools.UnitTesting;
using PhanNguyenKhoiNguyen_21068021_Module03;
using System;

namespace PhanNguyenKhoiNguyen_21068021_Test
{
    [TestClass]
    public class TestBai05
    {
        public TestContext TestContext { get; set; }

        [DataSource("Microsoft.VisualStudio.TestTools.DataSource.CSV",
        "|DataDirectory|\\dataBai05.csv", "dataBai05#csv", DataAccessMethod.Sequential),
        DeploymentItem("dataBai05.csv"), TestMethod()]
        public void testTriangle()
        {
            Module03 m = new Module03();
            int a = Int32.Parse(TestContext.DataRow[0].ToString());
            int b = Int32.Parse(TestContext.DataRow[1].ToString());
            int c = Int32.Parse(TestContext.DataRow[2].ToString());

            String expected = TestContext.DataRow[3].ToString();

            String actual = m.Triangle(a, b, c);
            Assert.AreEqual(expected, actual);
        }
    }
}
