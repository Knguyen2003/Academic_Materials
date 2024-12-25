using Microsoft.VisualStudio.TestTools.UnitTesting;
using System;
using System.Linq;

namespace PhanNguyenKhoiNguyen_21068021
{
    [TestClass]
    public class TestDataDriven12
    {
        public TestContext TestContext { get; set; }

        [DataSource("Microsoft.VisualStudio.TestTools.DataSource.CSV",
        "|DataDirectory|\\data_12.csv", "data_12#csv", DataAccessMethod.Sequential),
        DeploymentItem("data_12.csv"), TestMethod()]
        public void testDataDriven12()
        {
            MethodLibrary.MethodLibrary m = new MethodLibrary.MethodLibrary();
            int[] list = TestContext.DataRow[0].ToString()
                                        .Split(new[] { ',' }, StringSplitOptions.RemoveEmptyEntries)
                                        .Select(s => int.Parse(s.Trim()))
                                        .ToArray();
            int actualResult = m.Largest(list);
            int expectedResult = Int32.Parse(TestContext.DataRow[1].ToString());

            Assert.AreEqual(expectedResult, actualResult);
        }
    }
}
