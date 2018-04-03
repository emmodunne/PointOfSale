import javax.swing.*;

public class Payment {
    private JPanel PaymentPanel;
    private JTextField TotalTextField;
    private JComboBox PaymentMethodComboBox;
    private JTextField AmountTenderedTextBox;
    private JButton TenderButton;
    private JLabel TotalLabel;
    private JLabel PaymentMethodLabel;
    private JLabel AmountTenderedLabel;

    public static void openPaymentScreen(){
        JFrame frame = new JFrame("Payment");
        frame.setContentPane(new Payment().PaymentPanel);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setSize(300, 150);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
