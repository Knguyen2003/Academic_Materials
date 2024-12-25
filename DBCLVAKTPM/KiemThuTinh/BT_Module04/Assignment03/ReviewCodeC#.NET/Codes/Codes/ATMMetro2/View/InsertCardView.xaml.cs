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
    /// Interaction logic for InsertCardView.xaml
    /// </summary>
    public partial class InsertCardView : UserControl
    {
        public InsertCardView()
        {
            InitializeComponent();
            CardID.Focus();
        }

        private void OK_Click(object sender, RoutedEventArgs e)
        {
            switch (ValidationBus.ValadateCardID(CardID.Text))
            {
                case 1:
                    App.UpdateCurrentCard(CardID.Text);
                    App.UpdateCurrentAccount();
                    App.Navigate(new InsertPINView(App.Acc.ID));
                    break;
                case 0:
                    Note.Content = "Card was blocked!";
                    break;
                case 2:
                    Note.Content = "Card invalid";
                    break;
            }

        }

        private void Cancel_Click(object sender, RoutedEventArgs e)
        {

            App.Navigate(new WelcomeView());
        }

        private void Clear_Click(object sender, RoutedEventArgs e)
        {
            CardID.Text = string.Empty;
            CardID.Focus();
        }
    }
}
