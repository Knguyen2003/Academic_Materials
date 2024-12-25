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
using ATM.DAO;
using ATMMetro2.View;
using ATMMetro2;

namespace ATMMetro2.ChangePIN
{
    /// <summary>
    /// Interaction logic for ConfirmPIN.xaml
    /// </summary>
    public partial class ConfirmPIN : UserControl
    {
        private readonly string ConfirmPin = null;
        public ConfirmPIN()
        {
            InitializeComponent();
        }
        public ConfirmPIN(string PIN)
        {
            InitializeComponent();
            ConfirmPin = PIN;
        }

        private void OK_Click(object sender, RoutedEventArgs e)
        {
            if (ConfirmPin.Equals(PIN.Password))
            {
                if (ValidateUserCardbll.ChangePin(App.Card.ID, this.PIN.Password) == true)
                {
                    App.Navigate(new NewTransaction());
                }
                else
                {
                    txtConfirmPin.Visibility = Visibility.Visible;
                }
            }
            else
            {
                txtConfirmPin.Visibility = Visibility.Visible;
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
