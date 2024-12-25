using System.Data;
using System.Data.SqlClient;
using ATM.Common;
using ATM.Entities;

namespace ATM.DAO
{
    public class ValidateUserCardbll
    {
        private static SqlConnection cnn = null;
        public static CardModel ValidateCard(string ID)
        {
            CardModel cardModel=null;
            try{
            
            cardModel= new CardModel();
            cnn = SqlConnectionData.getConnection();
            string queryCommand = "Select * from Cards where Cards.ID=" + ID;
            SqlDataAdapter adapter = new SqlDataAdapter(queryCommand, cnn);
            DataTable da = new DataTable();
            adapter.Fill(da);
            if (da.Rows.Count > 0)
            {
                cardModel.ID = da.Rows[0]["ID"].ToString();
                cardModel.pin = da.Rows[0]["pin"].ToString();
                cardModel.status = da.Rows[0]["Status"].ToString();
                cardModel.AccID = da.Rows[0]["AccID"].ToString();
                cardModel.CreateDate = da.Rows[0]["CreateDate"].ToString();
                cardModel.ExpiredDate = da.Rows[0]["ExpiredDate"].ToString();
            }
            }catch
            {
                cnn.Close();
            }
            finally
            {
                cnn.Close();
            }

            return cardModel;
        }
        /// <summary>
        /// 
        /// </summary>
        /// <param name="ID"></param>
        /// <param name="newpin"></param>
        /// <returns></returns>
        public  static  bool ChangePin(string ID,string newpin)
        {
                try
                {
                    cnn = SqlConnectionData.getConnection();
                    if (newpin.Length ==6)
                    {
                        string updatequery = "Update Cards set Pin=" + newpin + " where ID=" + ID;
                        SqlCommand command = new SqlCommand(updatequery, cnn);
                        int count = command.ExecuteNonQuery();
                        if (count > 0) return true;
                        else return false; 
                    }
                    else
                    {
                        return false;
                    }
                    
                }
                catch
                {
                    throw;
                }
                finally
                {
                    cnn.Close();
                }
            return false;
        }
        public  static  bool CheckCurrentPin(string ID,string oldpin)
        {
            string sqlSelect = "Select * from Cards where Cards.ID=" + ID + " and Cards.Pin=" + oldpin;
            SqlCommand command =new SqlCommand(sqlSelect,cnn);
            SqlDataAdapter adapter=new SqlDataAdapter(command);
            DataTable table=new DataTable();
            adapter.Fill(table);
            if (table.Rows.Count == 0) return false;
            return true;
        }
    }
}
