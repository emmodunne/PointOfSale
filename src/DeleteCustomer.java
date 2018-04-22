import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteCustomer {
    private static JFrame delCustFrame;
    private JPanel deleteCustomerPanel;
    private JTable customerTable;
    private JLabel deleteCustomerLabel;
    private JTextField deleteField;
    private JButton deleteButton;
    private javax.swing.table.DefaultTableModel customerTableModel = new javax.swing.table.DefaultTableModel(){
        boolean[] canEdit = new boolean[]{
                false, false, false, false
        };

        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return canEdit[columnIndex];
        }
    };

    public DeleteCustomer() {
        customerTable.setModel(customerTableModel);
        customerTableModel.setDataVector(CustomerManagementDataHandler.getRows("Customers"),CustomerManagementDataHandler.getTitles("Customers"));
        delCustFrame.getRootPane().setDefaultButton(deleteButton);
        deleteField.requestFocus();
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(deleteField.getText().toString().isEmpty()){
                        JOptionPane.showMessageDialog(delCustFrame, "Delete field cannot be null value", "Error", JOptionPane.ERROR_MESSAGE);
                }else {
                    DeleteCustomerDataHandler.deleteCustomer(deleteField.getText().toString());
                    JOptionPane.showMessageDialog(delCustFrame, "Successfully deleted Customer", "Successfully deleted Customer", JOptionPane.INFORMATION_MESSAGE);
                    customerTable.setModel(customerTableModel);
                    customerTableModel.setDataVector(CustomerManagementDataHandler.getRows("Customers"),CustomerManagementDataHandler.getTitles("Customers"));
                    deleteField.setText(null);
                    deleteField.requestFocus();
                }
            }
        });
    }

        public static void openDeleteCustomerPanel() {
            delCustFrame = new JFrame("Delete Customer");
            delCustFrame.setContentPane(new DeleteCustomer().deleteCustomerPanel);
            delCustFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            delCustFrame.pack();
            delCustFrame.setSize(500, 600);
            delCustFrame.setLocationRelativeTo(null);
            delCustFrame.setVisible(true);
        }

}

