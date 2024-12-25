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
using ATMMetro2;

namespace ATMMetro2.View
{
    /// <summary>
    /// Interaction logic for AskForReceipt.xaml
    /// </summary>
    public partial class AskForReceipt : UserControl
    {
        public AskForReceipt()
        {
            InitializeComponent();
        }

        private void Button_Click(object sender, RoutedEventArgs e)
        {
            Button btn = (Button) sender;
            switch (btn.Name)
            {
                case "yesButton":
                    App.Navigate(new WaitforPrint());
                    break;
                case "noButton":
                    App.Navigate(new Thankyou());
                    break;

            }
        }
    }
}
