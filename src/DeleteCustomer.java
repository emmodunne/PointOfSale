import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by jonat on 17/04/2018.
 */
public class DeleteCustomer {

    private JPanel DeleteCustomerPanel;
    private JTable CustomerTable;
    private JLabel deleteCustomerLabel;
    private JTextField deleteField;
    private JButton DeleteButton;
    private javax.swing.table.DefaultTableModel CustomerTableModel = new javax.swing.table.DefaultTableModel();

    public DeleteCustomer() {
        CustomerTable.setModel(CustomerTableModel);
        CustomerTableModel.setDataVector(CustomerManagementDataHandler.getRows("Customers"),CustomerManagementDataHandler.getTitles("Customers"));


        DeleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(deleteField.getText().toString().isEmpty()){
                        JOptionPane.showMessageDialog(null, "Delete field cannot be null value", "Error", JOptionPane.ERROR_MESSAGE);
                }else {
                    JOptionPane.showMessageDialog(null, "Successfully deleted customer", "Added", JOptionPane.INFORMATION_MESSAGE);
                    DeleteCustomerDataHandler.deleteCustomer(deleteField.getText().toString());
                    CustomerTable.setModel(CustomerTableModel);
                    CustomerTableModel.setDataVector(CustomerManagementDataHandler.getRows("Customers"),CustomerManagementDataHandler.getTitles("Customers"));
                }
            }
        });
    }

        public static void openDeleteCustomerPanel() {
            JFrame frame = new JFrame("Delete Customer");
            frame.setContentPane(new DeleteCustomer().DeleteCustomerPanel);
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.pack();
            frame.setSize(500, 600);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        }

}

