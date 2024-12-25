using Microsoft.VisualStudio.TestTools.UnitTesting;
using PhanNguyenKhoiNguyen_21068021_Module03;
using System;

namespace PhanNguyenKhoiNguyen_21068021_Test
{
    [TestClass]
    public class TestBai13
    {
        public TestContext TestContext { get; set; }

        [DataSource("Microsoft.VisualStudio.TestTools.DataSource.CSV",
        "|DataDirectory|\\dataBai13.csv", "dataBai13#csv", DataAccessMethod.Sequential),
        DeploymentItem("dataBai13.csv"), TestMethod()]
        public void testBai13()
        {
            Module03 o = new Module03();
            int x1 = Int32.Parse(TestContext.DataRow[0].ToString());
            int y1 = Int32.Parse(TestContext.DataRow[1].ToString());
            int x2 = Int32.Parse(TestContext.DataRow[2].ToString());
            int y2 = Int32.Parse(TestContext.DataRow[3].ToString());
            int x = Int32.Parse(TestContext.DataRow[4].ToString());
            int y = Int32.Parse(TestContext.DataRow[5].ToString());


            Exception expectedException = null;
            if (x1 > x2 || y1 > y2)
            {
                try
                {
                    o.kiemTraXY_HCN(x1, y1, x2, y2, x, y);
                }
                catch (Exception ex)
                {
                    // Catches the exception
                    expectedException = ex;
                }
                Assert.IsNotNull(expectedException);

            }
            else
            {
                bool expected = Boolean.Parse(TestContext.DataRow[6].ToString());
                bool actual = o.kiemTraXY_HCN(x1, y1, x2, y2, x, y);
                Assert.AreEqual(expected, actual);
            }

        }
    }
}
