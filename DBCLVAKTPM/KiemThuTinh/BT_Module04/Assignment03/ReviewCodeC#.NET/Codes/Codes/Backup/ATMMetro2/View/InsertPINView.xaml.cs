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
using System.Windows.Navigation;
using System.Windows.Shapes;
using ATM.DAO;
using ATMMetro2;
using ATM.Bus;

namespace ATMMetro2.View
{
    /// <summary>
    /// Interaction logic for InsertPINView.xaml
    /// </summary>
    public partial class InsertPINView : UserControl
    {
        private static int count = 0;
        public InsertPINView()
        {
            InitializeComponent();
            PIN.Focus();
        }

        public InsertPINView(string accId)
        {
            InitializeComponent();
            PIN.Focus();
            WelcomeTitle.Text = "Welcome, " + ValidationBus.GetCusName(accId);
        }

        private void OK_Click(object sender, RoutedEventArgs e)
        {
            switch (ValidationBus.Authentication(App.Card, PIN.Password, count++))
            {
                case 0:
                    App.Navigate(new HomeView());
                    break;
                case 1:
                    App.Navigate(new Thankyou("Your card is blocked", true));
                    break;
                case 2:
                    Clear_Click(sender, e);
                    label1.Visibility = Visibility.Visible;
                    break;
            }
        }

        private void Cancel_Click(object sender, RoutedEventArgs e)
        {
            App.Navigate(new WelcomeView());
        }

        private void Clear_Click(object sender, RoutedEventArgs e)
        {
            PIN.Password = string.Empty;
            PIN.Focus();
        }
    }
}
