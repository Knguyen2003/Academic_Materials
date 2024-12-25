using System.Data.SqlClient;
using ATM.Common;

namespace ATM.DAO
{
    public class AuthenticateUserbll
    {
        private static SqlConnection _cnn = null;

        public static bool AuthenticateCard(string cardPIN, string enteredPIN)
        {
            if (cardPIN == enteredPIN) return true;
            return false;
        }

        public static bool UpdateStatus(string cardID)
        {
            try
            {
                _cnn = SqlConnectionData.GetConnection();
                var queryCommand = "update Cards set Status = " + 0 + " where ID =" + cardID;
                SqlCommand command = new SqlCommand(queryCommand, _cnn);
                int count = command.ExecuteNonQuery();
                if (count > 0) return true;
                return false;
            }
            catch
            {

            }
            finally
            {
                SqlConnectionData.CloseConnection();
            }
            return false;
        }
    }
}
