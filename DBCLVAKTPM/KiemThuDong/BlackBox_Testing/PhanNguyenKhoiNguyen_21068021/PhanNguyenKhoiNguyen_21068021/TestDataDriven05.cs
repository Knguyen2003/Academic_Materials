using Microsoft.VisualStudio.TestTools.UnitTesting;
using System;

namespace PhanNguyenKhoiNguyen_21068021
{
    [TestClass]
    public class TestDataDriven05
    {
        public TestContext TestContext { get; set; }

        [DataSource("Microsoft.VisualStudio.TestTools.DataSource.CSV",
        "|DataDirectory|\\data_05.csv", "data_05#csv", DataAccessMethod.Sequential),
        DeploymentItem("data_05.csv"), TestMethod()]
        public void testDataDriven05()
        {
            MethodLibrary.MethodLibrary o = new MethodLibrary.MethodLibrary();
            String sbin = TestContext.DataRow[0].ToString();
            String expectedResult = TestContext.DataRow[1].ToString();
            if (expectedResult.Equals("FormatException"))
            {
                Exception expectedException = null;
                try
                {
                    o.BinToDec(sbin);
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
                long actualResult = o.BinToDec(sbin);
                long expectedResult_long = long.Parse(expectedResult);
                Assert.AreEqual(expectedResult_long, actualResult);
            }
        }
    }
}
