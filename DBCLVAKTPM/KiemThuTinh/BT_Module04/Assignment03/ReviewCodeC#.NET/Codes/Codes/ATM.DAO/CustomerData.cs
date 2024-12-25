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
        public static string GetCustomerName(string cusId)
        {
            string name = string.Empty;
            cnn = SqlConnectionData.GetConnection();
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

        public static string GetCustomerID(string accID)
        {
            string cusID = "";
            cnn = SqlConnectionData.GetConnection();
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
