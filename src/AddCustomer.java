import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddCustomer {
    private JPanel addCustomerPanel;
    private JTextField firstNameField;
    private JTextField lastNameField;
    private JTextField phoneNumberField;
    private JButton addButton;
    private JLabel firstNameLabel;
    private JLabel lastNameLabel;
    private JLabel phoneNumberLabel;
    private static JFrame addCustFrame;

    public AddCustomer() {
        addCustFrame.getRootPane().setDefaultButton(addButton);
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(firstNameField.getText().toString().isEmpty()){
                    JOptionPane.showMessageDialog(addCustFrame, "First name cannot be null value", "Error", JOptionPane.ERROR_MESSAGE);
                }
                else if(lastNameField.getText().toString().isEmpty()){
                    JOptionPane.showMessageDialog(addCustFrame, "Last name cannot be null value", "Error", JOptionPane.ERROR_MESSAGE);
                }
                else if(phoneNumberField.getText().toString().isEmpty()){
                    JOptionPane.showMessageDialog(addCustFrame, "Phone number cannot be null value", "Error", JOptionPane.ERROR_MESSAGE);
                }
                else{
                    JOptionPane.showMessageDialog(addCustFrame, "Successfully added Customer", "Customer Added" , JOptionPane.INFORMATION_MESSAGE);
                    AddCustomerDataHandler.addCustomer(firstNameField.getText().toString(), lastNameField.getText().toString(), phoneNumberField.getText().toString());
                    addCustFrame.dispose();
                }
            }
        });
    }

    public static void openAddCustomerPanel() {
        addCustFrame = new JFrame("Add Customer");
        addCustFrame.setContentPane(new AddCustomer().addCustomerPanel);
        addCustFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        addCustFrame.pack();
        addCustFrame.setLocationRelativeTo(null);
        addCustFrame.setVisible(true);
    }
}