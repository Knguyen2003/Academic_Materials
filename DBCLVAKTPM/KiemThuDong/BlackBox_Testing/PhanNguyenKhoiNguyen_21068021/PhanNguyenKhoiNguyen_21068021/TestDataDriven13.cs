using Microsoft.VisualStudio.TestTools.UnitTesting;
using System;
using System.Linq;

namespace PhanNguyenKhoiNguyen_21068021
{
    [TestClass]
    public class TestDataDriven13
    {
        public TestContext TestContext { get; set; }

        [DataSource("Microsoft.VisualStudio.TestTools.DataSource.CSV",
        "|DataDirectory|\\data_13.csv", "data_13#csv", DataAccessMethod.Sequential),
        DeploymentItem("data_13.csv"), TestMethod()]
        public void testDataDriven13()
        {
            MethodLibrary.MethodLibrary m = new MethodLibrary.MethodLibrary();
            int[] a = TestContext.DataRow[0].ToString()
                            .Split(new[] { ',' }, StringSplitOptions.RemoveEmptyEntries)
                            .Select(s => int.Parse(s.Trim()))
                            .ToArray();
            int n = Int32.Parse(TestContext.DataRow[1].ToString());
            bool expectedResult = Boolean.Parse(TestContext.DataRow[2].ToString());
            bool actualResult = m.IsSymmetry(a, n);
            Assert.AreEqual(expectedResult, actualResult);
        }
    }
}
