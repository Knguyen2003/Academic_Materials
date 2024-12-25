using System;
using System.Collections.Generic;
using System.Data;
using System.Data.SqlClient;
using System.Linq;
using System.Text;
using ATM.Common;
using ATM.Entities;

namespace ATM.DAO
{
    public class CustomerData
    {
        private static SqlConnection cnn = null;
        public static string getCustomerName(string cusId)
        {
            string name = string.Empty;
            cnn = SqlConnectionData.getConnection();
            var queryCommand = "select * from Customers where ID = " + cusId;
            var adapter = new SqlDataAdapter(queryCommand, cnn);
            var da = new DataTable();
            adapter.Fill(da);
            if (da.Rows.Count > 0)
            {
                name = da.Rows[0]["Name"].ToString();
            }
            SqlConnectionData.CloseConnection();
            return name;
        }

        public static string getCustomerID(string accID)
        {
            string cusID = "";
            cnn = SqlConnectionData.getConnection();
            var queryCommand = "select * from Accounts " +
                               "Where ID = " + accID;
            var adapter = new SqlDataAdapter(queryCommand, cnn);
            var da = new DataTable();
            adapter.Fill(da);
            if (da.Rows.Count > 0)
            {
                cusID = da.Rows[0]["CusID"].ToString();
            }
            SqlConnectionData.CloseConnection();
            return cusID;
        }
    }
}
