using Microsoft.VisualStudio.TestTools.UnitTesting;
using System;
using System.Linq;

namespace PhanNguyenKhoiNguyen_21068021
{
    [TestClass]
    public class TestDataDriven14
    {
        public TestContext TestContext { get; set; }

        [DataSource("Microsoft.VisualStudio.TestTools.DataSource.CSV",
        "|DataDirectory|\\data_14.csv", "data_14#csv", DataAccessMethod.Sequential),
        DeploymentItem("data_14.csv"), TestMethod()]
        public void testDataDriven14()
        {
            MethodLibrary.MethodLibrary o = new MethodLibrary.MethodLibrary();
            int[] list = TestContext.DataRow[0].ToString()
                            .Split(new[] { ',' }, StringSplitOptions.RemoveEmptyEntries)
                            .Select(s => int.Parse(s.Trim()))
                            .ToArray();
            int left = Int32.Parse(TestContext.DataRow[1].ToString());
            int right = Int32.Parse(TestContext.DataRow[2].ToString());
            o.QuickSort(list, left, right);
            int[] expectedResult = TestContext.DataRow[3].ToString()
                            .Split(new[] { ',' }, StringSplitOptions.RemoveEmptyEntries)
                            .Select(s => int.Parse(s.Trim()))
                            .ToArray();

            CollectionAssert.AreEqual(expectedResult, list);
        }
    }
}
