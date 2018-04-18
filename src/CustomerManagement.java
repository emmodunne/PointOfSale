import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class CustomerManagement {
    private JPanel CustomerManagementPanel;
    private JButton addCustomerButton;
    private JTable CustomerTable;
    private JButton removeCustomerButton;
    private javax.swing.table.DefaultTableModel CustomerTableModel = new javax.swing.table.DefaultTableModel();

    public CustomerManagement() {
        CustomerTable.setModel(CustomerTableModel);
        CustomerTableModel.setDataVector(CustomerManagementDataHandler.getRows("Customers"),CustomerManagementDataHandler.getTitles("Customers"));
        addCustomerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddCustomer.openAddCustomerPanel();
            }
        });
        removeCustomerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DeleteCustomer.openDeleteCustomerPanel();
            }
        });
    }

    public static void openCustomerMangementPanel() {
        JFrame frame = new JFrame("Customer Mangement");
        frame.setContentPane(new CustomerManagement().CustomerManagementPanel);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setSize(1000, 500);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
