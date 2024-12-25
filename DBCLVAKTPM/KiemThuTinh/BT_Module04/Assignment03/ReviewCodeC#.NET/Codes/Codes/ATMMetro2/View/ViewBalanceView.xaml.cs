
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Shapes;
using ATM.DAO;
using ATMMetro2;

namespace ATMMetro2.View
{
    /// <summary>
    /// Interaction logic for ViewBalanceView.xaml
    /// </summary>
    public partial class ViewBalanceView : UserControl
    {
        public ViewBalanceView()
        {
            InitializeComponent();
            accBalance.Text = App.Acc.Balance.ToString();
            accOwner.Text = CustomerData.GetCustomerName(App.Acc.CusID);
        }
        
        private void OK_Click(object sender, RoutedEventArgs e)
        {
            App.Navigate(new WaitforPrint());
        }

        private void Button_Click(object sender, RoutedEventArgs e)
        {
            App.Navigate(new WaitforPrint());
        }
    }
}
