using Microsoft.VisualStudio.TestTools.UnitTesting;
using PhanNguyenKhoiNguyen_21068021_Module03;
using System;
using System.Globalization;

namespace PhanNguyenKhoiNguyen_21068021_Test
{
    [TestClass]
    public class TestBai14
    {
        public TestContext TestContext { get; set; }

        [DataSource("Microsoft.VisualStudio.TestTools.DataSource.CSV",
        "|DataDirectory|\\dataBai14.csv", "dataBai14#csv", DataAccessMethod.Sequential),
        DeploymentItem("dataBai14.csv"), TestMethod()]
        public void testIcon()
        {
            Module03 o = new Module03();

            float w = float.Parse(TestContext.DataRow[0].ToString());
            float h = float.Parse(TestContext.DataRow[1].ToString());

            float s,x,y;

            Exception expectedException = null;
            if (w < 0 || h < 0)
            {
                try
                {
                   o.Icon(w, h, out s, out x, out y);
                }
                catch (Exception ex)
                {
                    expectedException = ex;
                }
                Assert.IsNotNull(expectedException);

            }
            else
            {
                float expected_s = float.Parse(TestContext.DataRow[2].ToString());
                float expected_x = float.Parse(TestContext.DataRow[3].ToString(),new CultureInfo("vi-VN"));
                float expected_y = float.Parse(TestContext.DataRow[4].ToString(),new CultureInfo("vi-VN"));
                o.Icon(w, h, out s, out x, out y);
                Assert.AreEqual(expected_s, s);
                Assert.AreEqual(expected_x, x);
                Assert.AreEqual(expected_y, y);
            }
        }
    }
}
