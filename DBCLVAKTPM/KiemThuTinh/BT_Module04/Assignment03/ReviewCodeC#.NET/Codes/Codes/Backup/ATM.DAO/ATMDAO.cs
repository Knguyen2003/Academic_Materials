using System;
using System.Collections.Generic;
using System.Data;
using System.Data.SqlClient;
using ATM.Common;
using ATM.DAO;
using ATM.Entities;

namespace ATM.DAO
{
    public class ATMDAO
    {
        private static SqlConnection cnn = null;
        public  static List<ATMMoneyItem> GetMoneyStore()
        {
            var list = new List<ATMMoneyItem>(); 
            cnn = SqlConnectionData.getAtmConnection();
            string queryCommand = "Select * from ATMMoneyStore";
            var adapter = new SqlDataAdapter(queryCommand, cnn);
            var mn = new DataTable();
            adapter.Fill(mn);
            if (mn.Rows.Count > 0)
            {
                int count = 0;
                while (count < mn.Rows.Count)
                {
                    ATMMoneyItem money = new ATMMoneyItem();
                    money.Denomination = Convert.ToSingle(mn.Rows[count]["Denomination"].ToString());
                    money.Currency = mn.Rows[count]["Currency"].ToString();
                    money.Quantity = Convert.ToInt32(mn.Rows[count]["Quantity"].ToString());
                    list.Add(money);
                    count++;
                }
                
            }
            SqlConnectionData.CloseConnection();
            return list;
        }

        public static bool UpdateAtmDatabase(List<ATMMoneyItem> list)
        {
            if (list.Count != 0)
            {
                try
                {
                    cnn = SqlConnectionData.getAtmConnection();
                    for (int i = 0; i < list.Count; i++)
                    {
                        var queryCommand = "select Quantity from ATMMoneyStore where Denomination = " 
                                            + list[i].Denomination;
                        SqlDataAdapter adapter = new SqlDataAdapter(queryCommand, cnn);
                        DataTable da = new DataTable();
                        adapter.Fill(da);
                        if (da.Rows.Count > 0)
                        {
                            int c = 0;
                            while (c < da.Rows.Count)
                            {
                                int quantity = (int) da.Rows[c]["Quantity"];
                                string query = "update ATMMoneyStore set Quantity = " + (quantity - list[i].Quantity) +
                                               " where Denomination = " + list[i].Denomination;
                                SqlCommand command = new SqlCommand(query, cnn);
                                int count = command.ExecuteNonQuery();
                                if (count < 0) break;
                                c++;
                            }

                        }
                    }
                    return true;
                }
                catch (Exception)
                {  
                    throw;
                }
                finally
                {
                    cnn.Close();
                }  
            }
            return false;
        }
    }
}
