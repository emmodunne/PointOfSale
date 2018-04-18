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
                if(FirstNameField.getText().toString().isEmpty()){
                    JOptionPane.showMessageDialog(null, "First name cannot be null value", "Error", JOptionPane.ERROR_MESSAGE);
                }
                else if(LastNameField.getText().toString().isEmpty()){
                    JOptionPane.showMessageDialog(null, "Last name cannot be null value", "Error", JOptionPane.ERROR_MESSAGE);
                }
                else if(PhoneNumberField.getText().toString().isEmpty()){
                    JOptionPane.showMessageDialog(null, "Phone number cannot be null value", "Error", JOptionPane.ERROR_MESSAGE);
                }
                else{
                    JOptionPane.showMessageDialog(null, "Successfully added customer", "Added" , JOptionPane.INFORMATION_MESSAGE);
                    AddCustomerDataHandler.addCustomer(FirstNameField.getText().toString(), LastNameField.getText().toString(), PhoneNumberField.getText().toString());
                }
            }
        });
    }

    public static void openAddCustomerPanel() {
        JFrame frame = new JFrame("Add Customer");
        frame.setContentPane(new AddCustomer().AddCustomerPanel);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setSize(1000, 500);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}