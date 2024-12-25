using Microsoft.VisualStudio.TestTools.UnitTesting;
using PhanNguyenKhoiNguyen_21068021_Module03;
using System;
using System.Globalization;

namespace PhanNguyenKhoiNguyen_21068021_Test
{
    [TestClass]
    public class TestBai08
    {
        public TestContext TestContext { get; set; }

        [DataSource("Microsoft.VisualStudio.TestTools.DataSource.CSV",
        "|DataDirectory|\\dataBai08.csv", "dataBai08#csv", DataAccessMethod.Sequential),
        DeploymentItem("dataBai08.csv"), TestMethod()]
        public void testBai08()
        {
            Module03 m = new Module03();
            float a = float.Parse(TestContext.DataRow[0].ToString());
            float b = float.Parse(TestContext.DataRow[1].ToString());
            float c = float.Parse(TestContext.DataRow[2].ToString());

            float expected_x1 = float.Parse(TestContext.DataRow[3].ToString(), CultureInfo.InvariantCulture.NumberFormat);
            float expected_x2 = float.Parse(TestContext.DataRow[4].ToString(), CultureInfo.InvariantCulture.NumberFormat);

            string expected = TestContext.DataRow[5].ToString();


            float x1, x2;
            
            String actual = m.bai08(a, b, c, out x1, out x2);
            if (actual.Equals("error") || actual.Equals("no results"))
            {
                Assert.AreEqual(expected, actual);
                Assert.AreEqual(expected_x1, x1);
                Assert.AreEqual(expected_x2, x2);
            }
            else
            {
                Assert.AreEqual(expected_x1, x1, 0.01f);
                Assert.AreEqual(expected_x2, x2, 0.01f);
            }

        }

        
    }
}
