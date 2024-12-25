using Microsoft.VisualStudio.TestTools.UnitTesting;
using PhanNguyenKhoiNguyen_21068021_Module03;
using System;
using System.Globalization;

namespace PhanNguyenKhoiNguyen_21068021_Test
{
    [TestClass]
    public class TestBai11
    {
        public TestContext TestContext { get; set; }

        [DataSource("Microsoft.VisualStudio.TestTools.DataSource.CSV",
        "|DataDirectory|\\dataBai11.csv", "dataBai11#csv", DataAccessMethod.Sequential),
        DeploymentItem("dataBai11.csv"), TestMethod()]
        public void testBai11()
        {
            Module03 m = new Module03();
            float w = float.Parse(TestContext.DataRow[0].ToString());
            float h = float.Parse(TestContext.DataRow[1].ToString());
            float ww = float.Parse(TestContext.DataRow[2].ToString());
            float wh = float.Parse(TestContext.DataRow[3].ToString());

            float x, y;

            

            Exception expectedException = null;
            if (w <= 0 || h <= 0 || ww <= 0 || wh<= 0)
            {
                try
                {
                   m.bai11(out x,out y,w,h,ww,wh);
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

                float expected_x = float.Parse(TestContext.DataRow[4].ToString());
                string rawValue = TestContext.DataRow[5].ToString(); // Giá trị từ DataRow
                string formattedValue = rawValue.Replace(',', '.'); // Thay dấu phẩy thành dấu chấm

                float expected_y = float.Parse(formattedValue, CultureInfo.InvariantCulture);

                m.bai11(out x, out y, w, h, ww, wh);
                Assert.AreEqual(expected_x, x);
                Assert.AreEqual(expected_y, y);
            }
        }
    }
}
