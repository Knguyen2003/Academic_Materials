using Microsoft.VisualStudio.TestTools.UnitTesting;
using System;
using System.Globalization;


namespace PhanNguyenKhoiNguyen_21068021
{
    [TestClass]
    public class TestDataDriven08
    {
        public TestContext TestContext { get; set; }

        [DataSource("Microsoft.VisualStudio.TestTools.DataSource.CSV",
        "|DataDirectory|\\data_08.csv", "data_08#csv", DataAccessMethod.Sequential),
        DeploymentItem("data_08.csv"), TestMethod()]
        public void testDataDriven08()
        {
            MethodLibrary.MethodLibrary o = new MethodLibrary.MethodLibrary();
            int a = Int32.Parse(TestContext.DataRow[0].ToString());
            int b = Int32.Parse(TestContext.DataRow[1].ToString());
            double actualResult = o.TinhTienDien(a, b);
            double expectedResult = double.Parse(TestContext.DataRow[2].ToString(),new CultureInfo("vi-VN"));

            double delta = 0.001;
            Assert.AreEqual(expectedResult, actualResult, delta);
        }
    }
}
