using Microsoft.VisualStudio.TestTools.UnitTesting;
using PhanNguyenKhoiNguyen_21068021_Module03;
using System;

namespace PhanNguyenKhoiNguyen_21068021_Test
{
    [TestClass]
    public class TestBai06
    {
        public TestContext TestContext { get; set; }

        [DataSource("Microsoft.VisualStudio.TestTools.DataSource.CSV",
        "|DataDirectory|\\dataBai06.csv", "dataBai06#csv", DataAccessMethod.Sequential),
        DeploymentItem("dataBai06.csv"), TestMethod()]
        public void testAverage()
        {
            Module03 m = new Module03();
            int sum = Int32.Parse(TestContext.DataRow[0].ToString());
            int count = Int32.Parse(TestContext.DataRow[1].ToString());
            double expected = double.Parse(TestContext.DataRow[2].ToString());


            double actual = m.Average(sum,count);
            Assert.AreEqual(expected, actual);
        }
    }
}
