using System.Windows;
using System.Windows.Controls;
using ATM.DAO;
using ATMMetro2.ChangePIN;
using ATMMetro2;

namespace ATMMetro2.View
{
    /// <summary>
    /// Interaction logic for OldPIN.xaml
    /// </summary>
    public partial class OldPIN : UserControl
    {
        public OldPIN()
        {
            InitializeComponent();
        }

        private void OK_Click(object sender, RoutedEventArgs e)
        {
            if(this.PIN.Password.Equals(string.Empty))
            {
                TextErors.Visibility = Visibility.Visible;
                return;
            }
            else
            {
                if(ValidateUserCardbll.CheckCurrentPin(App.Card.ID,PIN.Password))
                {
                    App.Navigate(new NewPIN());
                }
                else
                {
                    TextErors.Visibility = Visibility.Visible;
                    return;
                }
            }
             
        }

        private void Clear_Click(object sender, RoutedEventArgs e)
        {
            PIN.Password = string.Empty;
            PIN.Focus();
        }

        private void Cancel_Click(object sender, RoutedEventArgs e)
        {
            App.Navigate(new WelcomeView());
        }
    }
}
