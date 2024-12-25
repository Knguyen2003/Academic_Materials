using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Shapes;
using ATMMetro2.View;
using ATMMetro2;

namespace ATMMetro2.ChangePIN
{
    /// <summary>
    /// Interaction logic for NewPIN.xaml
    /// </summary>
    public partial class NewPIN : UserControl
    {
        public NewPIN()
        {
            InitializeComponent();
        }

        private void OK_Click(object sender, RoutedEventArgs e)
        {

            if (PIN.Password.Equals(string.Empty) || PIN.Password.Length != 6)
            {
                TextErrors.Visibility = Visibility.Visible;
            }
            else
            {
                App.Navigate(new ConfirmPIN(PIN.Password));
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
