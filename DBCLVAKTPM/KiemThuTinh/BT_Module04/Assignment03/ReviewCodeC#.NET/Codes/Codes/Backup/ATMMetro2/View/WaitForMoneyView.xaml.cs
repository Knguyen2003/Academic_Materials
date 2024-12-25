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
using System.Windows.Threading;
using ATMMetro2;


namespace ATMMetro2.View
{
    /// <summary>
    /// Interaction logic for WaitForMoneyView.xaml
    /// </summary>
    public partial class WaitForMoneyView : UserControl
    {
        public WaitForMoneyView()
        {
            InitializeComponent();
        }
        private void Window_Loaded(object sender, RoutedEventArgs e)
        {
            DispatcherTimer tmr = new DispatcherTimer();
            tmr.Interval = TimeSpan.FromSeconds(2);
            tmr.Tick += timetick;
            tmr.Start();

        }
        private void timetick(object sender, EventArgs e)
        {
            App.Navigate(new AskForReceipt());
            ((DispatcherTimer) sender).Stop();
        }
    }
}
