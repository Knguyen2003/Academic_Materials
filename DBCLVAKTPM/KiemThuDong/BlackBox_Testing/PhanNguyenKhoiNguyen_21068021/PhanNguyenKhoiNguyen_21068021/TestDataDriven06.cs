using Microsoft.VisualStudio.TestTools.UnitTesting;
using System;

namespace PhanNguyenKhoiNguyen_21068021
{
    [TestClass]
    public class TestDataDriven06
    {
        public TestContext TestContext { get; set; }

        [DataSource("Microsoft.VisualStudio.TestTools.DataSource.CSV",
        "|DataDirectory|\\data_06.csv", "data_06#csv", DataAccessMethod.Sequential),
        DeploymentItem("data_06.csv"), TestMethod()]
        public void testDataDriven06()
        {
            MethodLibrary.MethodLibrary m = new MethodLibrary.MethodLibrary();
            int a = Int32.Parse(TestContext.DataRow[0].ToString()); ;
            int b = Int32.Parse(TestContext.DataRow[1].ToString()); ;
            int c = Int32.Parse(TestContext.DataRow[2].ToString()); ;

            String expectedResult = TestContext.DataRow[3].ToString();
            String actualResult = m.Triangle(a, b, c);
            Assert.AreEqual(expectedResult, actualResult);
        }
    }
}
