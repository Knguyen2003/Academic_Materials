using Microsoft.VisualStudio.TestTools.UnitTesting;
using System;
using System.Text;

namespace PhanNguyenKhoiNguyen_21068021
{
    [TestClass]
    public class TestDataDriven07
    {
        public TestContext TestContext { get; set; }

        [DataSource("Microsoft.VisualStudio.TestTools.DataSource.CSV",
        "|DataDirectory|\\data_07.csv", "data_07#csv", DataAccessMethod.Sequential),
        DeploymentItem("data_07.csv"), TestMethod()]
        public void testDataDriven07()
        {
            MethodLibrary.MethodLibrary m = new MethodLibrary.MethodLibrary();
            int a = Int32.Parse(TestContext.DataRow[0].ToString()); 
            int b = Int32.Parse(TestContext.DataRow[1].ToString()); 
            int c = Int32.Parse(TestContext.DataRow[2].ToString()); 
            float x1, x2;
            String expectedResult = Encoding.UTF8.GetString(Encoding.Default.GetBytes(TestContext.DataRow[3].ToString()));
            if(expectedResult.Equals("Vô số nghiệm") || expectedResult.Equals("Vô nghiệm"))
            {
                String actualResult = m.SolveQuadratic(a, b, c, out x1, out x2);
                Assert.AreEqual(expectedResult, actualResult);
                Assert.IsTrue(float.IsNaN(x1)); 
                Assert.IsTrue(float.IsNaN(x2));
            }
            else
            {
                String actualResult = m.SolveQuadratic(a, b, c, out x1, out x2);
                float expectedX1 = float.Parse(TestContext.DataRow[4].ToString()); 
                float expectedX2 = float.Parse(TestContext.DataRow[5].ToString());
                Assert.AreEqual(expectedResult, actualResult);
                Assert.AreEqual(expectedX1, x1, "x1 không đúng");
                Assert.AreEqual(expectedX2, x2, "x2 không đúng");

            }
        }
    }
}
