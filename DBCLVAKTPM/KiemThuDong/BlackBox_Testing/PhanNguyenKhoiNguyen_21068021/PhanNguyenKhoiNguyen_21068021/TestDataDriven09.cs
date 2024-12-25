using Microsoft.VisualStudio.TestTools.UnitTesting;
using System;

namespace PhanNguyenKhoiNguyen_21068021
{
    [TestClass]
    public class TestDataDriven09
    {
        public TestContext TestContext { get; set; }

        [DataSource("Microsoft.VisualStudio.TestTools.DataSource.CSV",
        "|DataDirectory|\\data_09.csv", "data_09#csv", DataAccessMethod.Sequential),
        DeploymentItem("data_09.csv"), TestMethod()]
        public void testDataDriven09()
        {
            MethodLibrary.MethodLibrary m = new MethodLibrary.MethodLibrary();
            long s0 = long.Parse(TestContext.DataRow[0].ToString());
            long s;
            long expectedResult = long.Parse(TestContext.DataRow[1].ToString());
            long actualResult = m.Sum(s0, out s);
            Assert.AreEqual(expectedResult, actualResult);
        }
    }
}
