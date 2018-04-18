import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EmployeeManagement {
    private JPanel EmployeeManagementPanel;
    private JTable employeeTable;
    private JButton addEmployeeButton;
    private JButton removeEmployeeButton;
    private javax.swing.table.DefaultTableModel EmployeeTableModel = new javax.swing.table.DefaultTableModel();

    public static void openEmployeeManagementPanel() {
        JFrame frame = new JFrame("Employee Management");
        frame.setContentPane(new EmployeeManagement().EmployeeManagementPanel);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setSize(1000, 500);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public EmployeeManagement() {


        addEmployeeButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                AddEmployee.openAddEmployeepane();
            }
        });
        removeEmployeeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}
