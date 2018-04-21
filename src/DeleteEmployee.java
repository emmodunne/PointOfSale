import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteEmployee {
    private JPanel deleteEmployeePanel;
    private JTable employeeTable;
    private JButton deleteButton;
    private JLabel deleteEmployeeLabel;
    private JTextField deleteField;
    private javax.swing.table.DefaultTableModel EmployeeTableModel = new javax.swing.table.DefaultTableModel(){
        boolean[] canEdit = new boolean[]{
                false, false, false, false, false
        };

        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return canEdit[columnIndex];
        }
    };


    public DeleteEmployee() {
        employeeTable.setModel(EmployeeTableModel);
        EmployeeTableModel.setDataVector(CustomerManagementDataHandler.getRows("Employee"),CustomerManagementDataHandler.getTitles("Employee"));


        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(deleteField.getText().toString().isEmpty()){
                    JOptionPane.showMessageDialog(null, "Delete field cannot be null value", "Error", JOptionPane.ERROR_MESSAGE);
                }else {
                    JOptionPane.showMessageDialog(null, "Successfully deleted employee", "Added", JOptionPane.INFORMATION_MESSAGE);
                    DeleteEmployeeDataHandler.deleteEmployee(deleteField.getText().toString());
                    employeeTable.setModel(EmployeeTableModel);
                    EmployeeTableModel.setDataVector(CustomerManagementDataHandler.getRows("Employee"), CustomerManagementDataHandler.getTitles("Employee"));
                }
            }
        });
    }

    public static void openDeleteEmployeePanel() {
        JFrame frame = new JFrame("Delete Customer");
        frame.setContentPane(new DeleteEmployee().deleteEmployeePanel);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setSize(500, 600);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
