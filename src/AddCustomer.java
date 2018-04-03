import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddCustomer {
    private JPanel AddCustomerPanel;
    private JTextField FirstNameField;
    private JTextField LastNameField;
    private JTextField PhoneNumberField;
    private JButton AddButton;
    private JLabel FirstNameLabel;
    private JLabel LastNameLabel;
    private JLabel PhoneNumberLabel;

    public AddCustomer() {
        AddButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            int result = AddCustomerDataHandler.addCustomer(FirstNameField.getText().toString(), LastNameField.getText().toString(), PhoneNumberField.getText().toString());

            }
        });
    }

    public static void openAddCustomerPanel() {
        JFrame frame = new JFrame("Add CustomerEmployee");
        frame.setContentPane(new AddCustomer().AddCustomerPanel);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setSize(300, 150);
        frame.setVisible(true);
    }
}