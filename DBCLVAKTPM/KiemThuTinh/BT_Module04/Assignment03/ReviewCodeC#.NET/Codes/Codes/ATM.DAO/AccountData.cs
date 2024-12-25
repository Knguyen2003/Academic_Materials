using System;
using System.Data;
using System.Data.SqlClient;
using ATM.Common;
using ATM.Entities;

namespace ATM.DAO
{
    public class AccountData
    {
        private static SqlConnection cnn = null;
        public static AccountModel GetCurrentAccount(string cardId)
        {
            var acc = new AccountModel();
            cnn = SqlConnectionData.GetConnection();
            try
            {
                string query = "Select * From Accounts  Join " +
                                "Cards On Accounts.ID = Cards.AccID "+
                                "And Cards.ID='"+ cardId +
                               "' Join AccountType  ON " +
                               "Accounts.AccountTypeID = AccountType.ID";
                //var command = new SqlCommand(query, cnn);
                var adapter = new SqlDataAdapter(query, cnn);
                var da = new DataTable();
                adapter.Fill(da);
                if (da.Rows.Count > 0)
                {
                    acc.ID = da.Rows[0]["ID"].ToString();
                    acc.CusID = da.Rows[0]["CusID"].ToString();
                    acc.Balance = float.Parse(da.Rows[0]["Balance"].ToString());
                    acc.OverDraft = float.Parse(da.Rows[0]["OverDraft"].ToString());
                    acc.AccountType = da.Rows[0]["Name"].ToString();
                    acc.ODLimit = float.Parse(da.Rows[0]["OverDraftLimit"].ToString());
                    acc.WithdrawLimit = float.Parse(da.Rows[0]["WithdrawLimit"].ToString());
                }
            }
            catch(Exception e)
            {
                Console.WriteLine(e.Message);
                return null;
            }
            finally
            {
                SqlConnectionData.CloseConnection();
            }
            return acc;
        }

        public static bool UpdateAccountMoney(string cardId, float money)
        {
            try
            {
                cnn = SqlConnectionData.GetConnection();
                var queryCommand = "select AccID from Cards where ID = " + cardId;
                SqlCommand command = new SqlCommand(queryCommand, cnn);
                SqlDataReader reader = command.ExecuteReader();
                while (reader.Read())
                {
                    var cusId = (string) reader[0];
                    reader.Close();
                    var query1 = "select Balance, OverDraft from Accounts where ID = " + cusId;
                    SqlCommand command1 = new SqlCommand(query1, cnn);
                    SqlDataReader rd = command1.ExecuteReader();
                    while (rd.Read())
                    {
                        double b = (double) rd[0];
                        double o = (double) rd[1];
                        float balance = (float) b;
                        float od = (float) o;
                        rd.Close();
                        if (money > balance)
                        {
                            od += (money - balance);
                            balance = money;
                        }
                        else balance -= money;
                        var query = "update Accounts set Balance = " + balance 
                                + ", OverDraft = " + od + " where ID = " + cusId;
                        SqlCommand com = new SqlCommand(query, cnn);
                        int count = com.ExecuteNonQuery();
                        if (count > 0) return true;
                        return false;
                    }
                }
                
            }
            catch (Exception)
            {
                throw;
            }

            finally
            {
                cnn.Close();
            }

            return false;
        }
         
    }
}
