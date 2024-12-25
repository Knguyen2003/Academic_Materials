using System;
using System.Windows;
using System.Windows.Controls;
using ATM.Common;
using ATM.Entities;
using ATMMetro2;
using ATM.Bus;

namespace ATMMetro2.View
{
    /// <summary>
    /// Interaction logic for AmountofMoney.xaml
    /// </summary>
    public partial class AmountofMoney : UserControl
    {
        public AmountofMoney()
        {
            InitializeComponent();
            Money.Focus();
        }

        public AmountofMoney(float withdrawMoney)
        {
            InitializeComponent();
            App.WithdrawNavigate(withdrawMoney);
        }
        private void Clear_Click(object sender, System.Windows.RoutedEventArgs e)
        {
            Money.Text = string.Empty;
            Money.Focus();
        }

        private void Cancel_Click(object sender, System.Windows.RoutedEventArgs e)
        {
            App.Navigate(new WelcomeView());
        }

        private void OK_Click(object sender, System.Windows.RoutedEventArgs e)
        {
            if (String.IsNullOrEmpty(Money.Text))
            {
                Notice2.Visibility = Visibility.Visible;
                Notice1.Visibility = Visibility.Collapsed;
                Notice3.Visibility = Visibility.Collapsed;
                Notice4.Visibility = Visibility.Collapsed;
            }
            else
            {
                var m = Int64.Parse(Money.Text);
                if (m >= 50000 && m <= 5000000)
                {
                    // Neu so tien rut khong la boi cua 50k
                    if (m % 50000 == 0)
                    {
                        App.WithdrawNavigate(float.Parse(Money.Text));
                    }
                    else
                    {
                        Notice3.Visibility = Visibility.Visible;
                        Notice2.Visibility = Visibility.Collapsed;
                        Notice1.Visibility = Visibility.Collapsed;
                        Notice4.Visibility = Visibility.Collapsed;
                    }
                }
                else 
                {
                    // Neu nguoi dung dien ngoai [50,000-5,000,000]
                    Notice1.Visibility = Visibility.Visible;
                    Notice2.Visibility = Visibility.Collapsed;
                    Notice3.Visibility = Visibility.Collapsed;
                    Notice4.Visibility = Visibility.Collapsed;
                }
            }
        }
    }
}
