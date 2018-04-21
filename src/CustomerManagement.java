import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class CustomerManagement {
    private JPanel CustomerManagementPanel;
    private JButton addCustomerButton;
    private JTable CustomerTable;
    private JButton removeCustomerButton;
    private static JFrame custMangFrame;
    private javax.swing.table.DefaultTableModel CustomerTableModel = new javax.swing.table.DefaultTableModel();

    public CustomerManagement() {
        CustomerTable.setModel(CustomerTableModel);
        CustomerTableModel.setDataVector(CustomerManagementDataHandler.getRows("Customers"),CustomerManagementDataHandler.getTitles("Customers"));
        addCustomerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddCustomer.openAddCustomerPanel();
                custMangFrame.dispose();
            }
        });
        removeCustomerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DeleteCustomer.openDeleteCustomerPanel();
                custMangFrame.dispose();
            }
        });
    }

    public static void openCustomerMangementPanel() {
        custMangFrame = new JFrame("Customer Mangement");
        custMangFrame.setContentPane(new CustomerManagement().CustomerManagementPanel);
        custMangFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        custMangFrame.pack();
        custMangFrame.setSize(500, 600);
        custMangFrame.setLocationRelativeTo(null);
        custMangFrame.setVisible(true);
    }

}
