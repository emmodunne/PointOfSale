import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EmployeeManagement {
    private JPanel EmployeeManagementPanel;
    private JButton AddEmployee;

    public static void openEmployeeManagementPanel() {
        JFrame frame = new JFrame("Employee Management");
        frame.setContentPane(new EmployeeManagement().EmployeeManagementPanel);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setSize(1000, 500);
        frame.setVisible(true);
    }

    public EmployeeManagement() {
        AddEmployee.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}
