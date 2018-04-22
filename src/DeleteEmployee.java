import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteEmployee {
    private static JFrame delEmployeeFrame;
    private JPanel deleteEmployeePanel;
    private JTable employeeTable;
    private JButton deleteButton;
    private JLabel deleteEmployeeLabel;
    private JTextField deleteField;
    private javax.swing.table.DefaultTableModel employeeTableModel = new javax.swing.table.DefaultTableModel();


    public DeleteEmployee() {
        employeeTable.setModel(employeeTableModel);
        employeeTableModel.setDataVector(CustomerManagementDataHandler.getRows("Employee"),CustomerManagementDataHandler.getTitles("Employee"));
        delEmployeeFrame.getRootPane().setDefaultButton(deleteButton);
        deleteField.requestFocus();
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(deleteField.getText().toString().isEmpty()){
                    JOptionPane.showMessageDialog(delEmployeeFrame, "Delete field cannot be null value", "Error", JOptionPane.ERROR_MESSAGE);
                }else {
                    DeleteEmployeeDataHandler.deleteEmployee(deleteField.getText().toString());
                    JOptionPane.showMessageDialog(delEmployeeFrame, "Successfully deleted Employee", "Successfully Deleted Employee", JOptionPane.INFORMATION_MESSAGE);
                    employeeTable.setModel(employeeTableModel);
                    employeeTableModel.setDataVector(CustomerManagementDataHandler.getRows("Employee"), CustomerManagementDataHandler.getTitles("Employee"));
                    deleteField.setText(null);
                    deleteField.requestFocus();
                }
            }
        });
    }

    public static void openDeleteEmployeePanel() {
        delEmployeeFrame = new JFrame("Delete Customer");
        delEmployeeFrame.setContentPane(new DeleteEmployee().deleteEmployeePanel);
        delEmployeeFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        delEmployeeFrame.pack();
        delEmployeeFrame.setSize(500, 600);
        delEmployeeFrame.setLocationRelativeTo(null);
        delEmployeeFrame.setVisible(true);
    }
}
