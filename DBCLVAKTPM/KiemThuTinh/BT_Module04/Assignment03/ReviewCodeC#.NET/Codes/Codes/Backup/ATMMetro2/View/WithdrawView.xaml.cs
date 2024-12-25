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
using ATM.Bus;
using ATMMetro2;

namespace ATMMetro2.View
{
    /// <summary>
    /// Interaction logic for WithdrawView.xaml
    /// </summary>
    public partial class WithdrawView : UserControl
    {
        public WithdrawView()
        {
            InitializeComponent();
        }

        private void Button_Click(object sender, RoutedEventArgs e)
        {
            Button btn = (Button) sender;
            switch (btn.Name) 
            {
                case "exitButton":
                    App.Navigate(new WelcomeView());
                    break;
                case "withdrawalButton0":
                    App.WithdrawNavigate(200000);
                    break;
                case "withdrawalButton1":
                    App.WithdrawNavigate(500000);
                    break;
                case "withdrawalButton2":
                    App.WithdrawNavigate(1000000);
                    break;
                case "withdrawalButton3":
                    App.WithdrawNavigate(2000000);
                    break;
                case "withdrawalButton4":
                    App.WithdrawNavigate(5000000);
                    break;
                case "withdrawalButton5":
                    App.Navigate(new AmountofMoney());
                    break;
            }
        }

    }
}
