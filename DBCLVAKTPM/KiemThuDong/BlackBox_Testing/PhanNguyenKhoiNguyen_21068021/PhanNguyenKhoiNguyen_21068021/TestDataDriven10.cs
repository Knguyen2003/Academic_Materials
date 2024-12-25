using Microsoft.VisualStudio.TestTools.UnitTesting;
using System;

namespace PhanNguyenKhoiNguyen_21068021
{
    [TestClass]
    public class TestDataDriven10
    {
        public TestContext TestContext { get; set; }

        [DataSource("Microsoft.VisualStudio.TestTools.DataSource.CSV",
        "|DataDirectory|\\data_10.csv", "data_10#csv", DataAccessMethod.Sequential),
        DeploymentItem("data_10.csv"), TestMethod()]
        public void TestMethod1()
        {
            MethodLibrary.MethodLibrary o = new MethodLibrary.MethodLibrary();
            String s = TestContext.DataRow[0].ToString();
            int n = Int32.Parse(TestContext.DataRow[1].ToString());
            int p = Int32.Parse(TestContext.DataRow[2].ToString());

            String expectedResult = TestContext.DataRow[3].ToString();

            String actualResult = o.HuyChuoi(s, n, p);

            Assert.AreEqual(expectedResult, actualResult);
        }
    }
}
