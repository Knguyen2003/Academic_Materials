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
    public class CardDAO
    {
        private static SqlConnection cnn = null;
        public static CardModel GetCurrentCard(string cardId)
        {
            var card = new CardModel();
            cnn = SqlConnectionData.GetConnection();
            try
            {
                string query = "Select * From Cards Where " +
                               "Cards.ID=" + cardId;
                //var command = new SqlCommand(query, cnn);
                var adapter = new SqlDataAdapter(query, cnn);
                var da = new DataTable();
                adapter.Fill(da);
                if (da.Rows.Count > 0)
                {
                    card.ID = da.Rows[0]["ID"].ToString();
                    card.Pin = da.Rows[0]["Pin"].ToString();
                    card.Status = da.Rows[0]["Status"].ToString();
                    card.AccID = da.Rows[0]["AccID"].ToString();
                    card.CreateDate = da.Rows[0]["CreateDate"].ToString();
                    card.ExpiredDate = da.Rows[0]["ExpiredDate"].ToString();
                }
            }
            catch (Exception e)
            {
                Console.WriteLine(e.Message);
                return null;
            }
            finally
            {
                SqlConnectionData.CloseConnection();
            }
            return card;
        }
    }
}
