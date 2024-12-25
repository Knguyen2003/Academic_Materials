using Microsoft.VisualStudio.TestTools.UnitTesting;
using System;

namespace PhanNguyenKhoiNguyen_21068021
{
    [TestClass]
    public class TestDataDriven04
    {
        public TestContext TestContext { get; set; }

        [DataSource("Microsoft.VisualStudio.TestTools.DataSource.CSV",
        "|DataDirectory|\\data_04.csv", "data_04#csv", DataAccessMethod.Sequential),
        DeploymentItem("data_04.csv"), TestMethod()]
        public void testDataDriven04()
        {
            MethodLibrary.MethodLibrary o = new MethodLibrary.MethodLibrary();
            int n = Int32.Parse(TestContext.DataRow[0].ToString());
            if (n < 1582)
            {
                Exception expectedException = null;
                try
                {
                    o.IsLeapYear(n);
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
                bool actual = o.IsLeapYear(n);
                bool expectedResult = Boolean.Parse(TestContext.DataRow[1].ToString());
                Assert.AreEqual(expectedResult, actual);
            }
        }
    }
}
