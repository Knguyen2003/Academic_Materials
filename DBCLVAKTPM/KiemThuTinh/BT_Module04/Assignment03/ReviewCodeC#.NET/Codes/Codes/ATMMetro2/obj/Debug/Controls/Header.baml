   M S B A M L   `   `   `  ����  	ATMMetro2    ATMMetro2.Controls.Header   5      R NWindowsBase, Version=3.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35\ XPresentationFramework, Version=3.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35W SPresentationCore, Version=3.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35D 9http://schemas.microsoft.com/winfx/2006/xaml/presentation    5      8x,http://schemas.microsoft.com/winfx/2006/xaml    5      $	��100��5      $	��800��6     � 	Resources  5         HeaderTextStyle �� 
TargetType �� Property �� Value��%x   &	        �� 5   
   " ��6(   .�5      ��  � ��
 �  ��6+   �� 5       � ��$ 30(�6)   5	      5
      .��5      �  � RowDefinitions 5   
   �� 5      $��8* �6   �� 5      $��2* �6   .+�5   
   �� -   5         ��Name$ BackLogo��5      $��20 10 10 10q�5      $
��Left=�5      $.��(/ATMMetro2;component/Images/BankLogo.jpg��5      �� 5   
   -   5         ��Name$ BackName��5      $��
Metro Bank��5      $��Center=�5      $��90 0 0 0q�5      $
��Left=�5      #��[  5       � Triggers 5      :� 5       :� RoutedEvent$ Window.Loaded��6   .[�5      �� .��5      �� 	 g� RepeatBehavior$	 Forever��6%   
 g� AutoReverse
 . .��5      W�  �� 
TargetName$ BackName��6.    �� TargetProperty$ FontSize�5    .    W� From$ 50X�5!   .   	 W� To$ 30X�68    g� Duration$ 0:0:2D�6@    g� 	BeginTime$ 0:0:0X�5"   .   t� 5#      $ BackName��61   $ Margin�5$   .   $ 0:0:2.2X�5%   .    t� From$ 90 0 0 0X�5&   .   	 t� To$ 	120 0 0 0X�5'   .   $ 0:0:1D�5(   .   W� 5)      $ BackName��6.   $ Opacity�5*   .   $ 0:0:4.5X�5+   .   $ 1X�5,   .   $ 0X�5-   .   $ 0:0:1D�5.   .   5/      50      51      53      � 54   
   $��1��6   
���  ��6   55      56      