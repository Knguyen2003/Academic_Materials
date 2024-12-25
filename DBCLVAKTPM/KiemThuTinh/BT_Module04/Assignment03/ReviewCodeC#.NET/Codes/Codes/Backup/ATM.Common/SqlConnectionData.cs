using System.Data.SqlClient;

namespace ATM.Common
{
    public class SqlConnectionData
    {
        private static SqlConnection cnn = null;
        public  static  SqlConnection getConnection()
        {
            string strcnn = "Data Source=10.16.102.151;Initial Catalog=ATMdotNet2;Persist Security Info=True;User ID=Fresher;Password=12345";     
            cnn=new SqlConnection(strcnn);
            cnn.Open();
            return cnn;
        }

        public static SqlConnection getAtmConnection()
        {
            string strcnn = "Data Source=10.16.102.151;Initial Catalog=ATMdotNet2.ATM;Persist Security Info=True;User ID=Fresher;Password=12345";
            cnn = new SqlConnection(strcnn);
            cnn.Open();
            return cnn;
        }

        public  static  void CloseConnection()
        {
            try
            {
                if(cnn!=null) cnn.Close();
            }catch
            {
            }finally
            {
                cnn.Close();
            }
        }
    }
}
