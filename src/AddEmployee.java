import javax.swing.*;

public class AddEmployee {
    private JPanel AddEmployeePanel;
    private JTextField textField1;
    private JTextField textField2;
    private JComboBox comboBox1;
    private JTextField textField3;
    private JButton button1;

    public static void openAddEmployeepane() {
        JFrame frame = new JFrame("Add Employee");
        frame.setContentPane(new AddEmployee().AddEmployeePanel);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setSize(1000, 500);
        frame.setVisible(true);
    }
}
