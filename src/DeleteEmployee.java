import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteEmployee {
    private JPanel deleteEmployeePanel;
    private JTable employeeTable;
    private JButton deleteButton;
    private JLabel deleteEmployeeLabel;
    private JTextField deleteField;
    private javax.swing.table.DefaultTableModel EmployeeTableModel = new javax.swing.table.DefaultTableModel();
    private static JFrame deleteCustomerFrame;


    public DeleteEmployee() {
        employeeTable.setModel(EmployeeTableModel);
        EmployeeTableModel.setDataVector(CustomerManagementDataHandler.getRows("Employee"),CustomerManagementDataHandler.getTitles("Employee"));


        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(deleteField.getText().toString().isEmpty()){
                    JOptionPane.showMessageDialog(null, "Delete field cannot be null value", "Error", JOptionPane.ERROR_MESSAGE);
                }else {
                    DeleteEmployeeDataHandler.deleteEmployee(deleteField.getText().toString());
                    JOptionPane.showMessageDialog(null, "Successfully deleted employee", "Added", JOptionPane.INFORMATION_MESSAGE);
                    deleteCustomerFrame.dispose();
                    EmployeeManagement.openEmployeeManagementPanel();
                }
            }
        });
    }

    public static void openDeleteEmployeePanel() {
        deleteCustomerFrame = new JFrame("Delete Customer");
        deleteCustomerFrame.setContentPane(new DeleteEmployee().deleteEmployeePanel);
        deleteCustomerFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        deleteCustomerFrame.pack();
        deleteCustomerFrame.setSize(500, 600);
        deleteCustomerFrame.setLocationRelativeTo(null);
        deleteCustomerFrame.setVisible(true);
    }
}
