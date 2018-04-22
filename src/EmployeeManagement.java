import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EmployeeManagement {
    private JPanel employeeManagementPanel;
    private JTable employeeTable;
    private JButton addEmployeeButton;
    private JButton removeEmployeeButton;
    private javax.swing.table.DefaultTableModel EmployeeTableModel = new javax.swing.table.DefaultTableModel(){
        boolean[] canEdit = new boolean[]{
                false, false, false, false, false
        };

        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return canEdit[columnIndex];
        }
    };

    private static JFrame empMangFrame;

    public static void openEmployeeManagementPanel() {
        empMangFrame = new JFrame("Employee Management");
        empMangFrame.setContentPane(new EmployeeManagement().employeeManagementPanel);
        empMangFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        empMangFrame.pack();
        empMangFrame.setSize(500, 600);
        empMangFrame.setLocationRelativeTo(null);
        empMangFrame.setVisible(true);
    }

    public EmployeeManagement() {
        employeeTable.setModel(EmployeeTableModel);
        EmployeeTableModel.setDataVector(CustomerManagementDataHandler.getRows("Employee"),CustomerManagementDataHandler.getTitles("Employee"));

        addEmployeeButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                AddEmployee.openAddEmployeepanel();
            }
        });
        removeEmployeeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DeleteEmployee.openDeleteEmployeePanel();
                empMangFrame.dispose();
            }
        });
    }
}
