using Microsoft.VisualStudio.TestTools.UnitTesting;
using PhanNguyenKhoiNguyen_21068021_Module03;
using System;

namespace PhanNguyenKhoiNguyen_21068021_Test
{
    [TestClass]
    public class TestBai12
    {
        public TestContext TestContext { get; set; }

        [DataSource("Microsoft.VisualStudio.TestTools.DataSource.CSV",
        "|DataDirectory|\\dataBai12.csv", "dataBai12#csv", DataAccessMethod.Sequential),
        DeploymentItem("dataBai12.csv"), TestMethod()]
        public void testBai13()
        {
            Module03 o = new Module03();
            float total = float.Parse(TestContext.DataRow[3].ToString());
            float p1 = float.Parse(TestContext.DataRow[0].ToString());
            float p2 = float.Parse(TestContext.DataRow[1].ToString());
            float p3 = float.Parse(TestContext.DataRow[2].ToString());
            

            Exception expectedException = null;
            if ((p1 < 0) || (p2 < 0) || (p3 < 0) || (total < 0))
            {
                try
                {
                    o.tienNuoc(p1, p2, p3, total);
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
                float expected = float.Parse(TestContext.DataRow[4].ToString());
                float actual = o.tienNuoc(p1, p2, p3, total);
                Assert.AreEqual(expected, actual);
            }

        }
    }
}
