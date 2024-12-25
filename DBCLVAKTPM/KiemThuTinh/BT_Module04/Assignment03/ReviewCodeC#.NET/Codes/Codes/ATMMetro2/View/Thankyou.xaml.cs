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
using System.Windows.Threading;
using ATMMetro2;

namespace ATMMetro2.View
{
    /// <summary>
    /// Interaction logic for Thankyou.xaml
    /// </summary>
    public partial class Thankyou : UserControl
    {
        private static bool isWithdraw = true;
        public Thankyou()
        {
            InitializeComponent();
        }

        public Thankyou(string str, bool isWd)
        {
            InitializeComponent();
            messTextBlock.Text = str;
            isWithdraw = isWd;
        }

        private void UserControl_Loaded(object sender, RoutedEventArgs e)
        {
            DispatcherTimer tmr = new DispatcherTimer
            {
                Interval = TimeSpan.FromSeconds(2)
            };
            tmr.Tick += Timetick;
            tmr.Start();

        }
        private void Timetick(object sender, EventArgs e)
        {
            if (!isWithdraw)
            {
                if (App.MainFrame.NavigationService.CanGoBack)
                    App.MainFrame.NavigationService.GoBack();
            }
            else App.Navigate(new WelcomeView());
            ((DispatcherTimer)sender).Stop();

        }
    }
}
