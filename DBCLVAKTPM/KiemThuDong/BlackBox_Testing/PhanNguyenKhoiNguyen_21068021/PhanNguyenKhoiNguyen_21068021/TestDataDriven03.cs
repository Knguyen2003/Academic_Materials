using Microsoft.VisualStudio.TestTools.UnitTesting;
using System;

namespace PhanNguyenKhoiNguyen_21068021
{

    [TestClass]
    public class TestDataDriven03
    {
        public TestContext TestContext { get; set; }

        [DataSource("Microsoft.VisualStudio.TestTools.DataSource.CSV",
        "|DataDirectory|\\data_03.csv", "data_03#csv", DataAccessMethod.Sequential),
        DeploymentItem("data_03.csv"), TestMethod()]
        public void testDataDriven03()
        {
            MethodLibrary.MethodLibrary o = new MethodLibrary.MethodLibrary();
            int num = Int32.Parse(TestContext.DataRow[0].ToString());
            if(num < 0 || num > 1000)
            {
                Exception expectedException = null;
                try
                {
                    o.primeCheck(num);
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
                bool actual = o.primeCheck(num);
                bool expectedResult = Boolean.Parse(TestContext.DataRow[1].ToString());
                Assert.AreEqual(expectedResult, actual);

            }
 
        }
    }
}
