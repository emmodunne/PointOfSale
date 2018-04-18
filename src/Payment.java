import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Payment {
    private JPanel PaymentPanel;
    private JLabel totalLabel;
    private JLabel paymentMethodLabel;
    private JLabel amountTenderedLabel;
    private JButton tenderButton;
    private JTextField totalText;
    private JButton cancelButton;
    private JTextField amountTenderedText;
    private JLabel saleTotalLabel;
    private JComboBox paymentMethodCombo;

    public Payment(double saleTotal) {
        saleTotalLabel.setText(String.format ("€%.2f", saleTotal));
        paymentMethodCombo.requestFocus();
        amountTenderedText.setText(String.format ("%.2f", saleTotal));
        tenderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Frame[] frames = Frame.getFrames();
                for (Frame frame : frames) {
                    if (frame.getTitle().equals("Payment"));
                    frame.setVisible(false); //you can't see me!
                    frame.dispose();
                }
            }
        });
    }

    public static void openPaymentScreen(double saleTotal){
        JFrame frame = new JFrame();
        frame.setUndecorated(true);
        frame.setContentPane(new Payment(saleTotal).PaymentPanel);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
