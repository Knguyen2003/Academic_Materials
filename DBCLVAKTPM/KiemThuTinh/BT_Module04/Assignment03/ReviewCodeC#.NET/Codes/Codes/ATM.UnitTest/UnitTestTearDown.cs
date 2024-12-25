using System;
using System.Collections.Generic;
using System.EnterpriseServices;
using System.Linq;
using System.Text;
using NUnit.Framework;

namespace ATM.UnitTest
{
    public class UnitTestTearDown
    {
        [TearDown]
        public void Teardown()
        {
            Console.WriteLine("Attempting to Leave transactional context...");
            if (ContextUtil.IsInTransaction)
            {
                // Abort the running transaction					
                ContextUtil.SetAbort();
            }
            ServiceDomain.Leave();
            Console.WriteLine("Left context!");
            // Trying to access ContextUtil now will yield an exception					

        }					
    }
}
