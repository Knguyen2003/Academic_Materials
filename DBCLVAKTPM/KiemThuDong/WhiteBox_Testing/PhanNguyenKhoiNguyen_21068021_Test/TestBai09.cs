using Microsoft.VisualStudio.TestTools.UnitTesting;
using PhanNguyenKhoiNguyen_21068021_Module03;
using System;

namespace PhanNguyenKhoiNguyen_21068021_Test
{
    [TestClass]
    public class TestBai09
    {
        public TestContext TestContext { get; set; }

        [DataSource("Microsoft.VisualStudio.TestTools.DataSource.CSV",
        "|DataDirectory|\\dataBai09.csv", "dataBai09#csv", DataAccessMethod.Sequential),
        DeploymentItem("dataBai09.csv"), TestMethod()]
        public void testBai09()
        {
            Module03 m = new Module03();
            float a = float.Parse(TestContext.DataRow[0].ToString());
            float b = float.Parse(TestContext.DataRow[1].ToString());
            float x = float.Parse(TestContext.DataRow[2].ToString());

            

            Exception expectedException = null;
            if (a > b)
            {
                try
                {
                    m.bai09(a,b,x);
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
                float expected = float.Parse(TestContext.DataRow[3].ToString());
                float actual = m.bai09(a, b, x);
                Assert.AreEqual(expected, actual);
            }
        }
    }
}
