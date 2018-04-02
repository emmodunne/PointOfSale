import javax.swing.*;

public class AddEmployee {
    private JPanel AddEmployeePanel;

    public static void openAddEmployeepanel() {
        JFrame frame = new JFrame("Add Employee");
        frame.setContentPane(new AddEmployee().AddEmployeePanel);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setSize(1000, 500);
        frame.setVisible(true);
    }
}
