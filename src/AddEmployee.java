import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class AddEmployee {
    private JPanel AddEmployeePanel;
    private JTextField FirstNameField;
    private JTextField LastNameField;
    private JComboBox PositionComboBox;
    private JTextField EmailField;
    private JButton AddEmployeeButton;
    private static JFrame empFrame;


    public AddEmployee() {
        PositionComboBox.setModel(new javax.swing.DefaultComboBoxModel(getPositions()));
        AddEmployeeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(FirstNameField.getText().toString().isEmpty()){
                    JOptionPane.showMessageDialog(null, "First name cannot be null value", "Error", JOptionPane.ERROR_MESSAGE);
                }
                else if(LastNameField.getText().toString().isEmpty()){
                    JOptionPane.showMessageDialog(null, "Last name cannot be null value", "Error", JOptionPane.ERROR_MESSAGE);
                }
                else if(PositionComboBox.getSelectedItem().toString().isEmpty()){
                    JOptionPane.showMessageDialog(null, "Phone number cannot be null value", "Error", JOptionPane.ERROR_MESSAGE);
                }
                else if(EmailField.getText().toString().isEmpty()){
                    JOptionPane.showMessageDialog(null, "Phone number cannot be null value", "Error", JOptionPane.ERROR_MESSAGE);
                }
                else{
                    JOptionPane.showMessageDialog(null, "Successfully added employee", "Added" , JOptionPane.INFORMATION_MESSAGE);
                    AddEmployeeDataHandler.addEmployee(FirstNameField.getText().toString(), LastNameField.getText().toString(), PositionComboBox.getSelectedItem().toString(), EmailField.getText().toString());
                    empFrame.dispose();
                    EmployeeManagement.openEmployeeManagementPanel();
                }
            }
        });
    }

    public static void openAddEmployeepanel() {
        empFrame = new JFrame("Add Employee");
        empFrame.setContentPane(new AddEmployee().AddEmployeePanel);
        empFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        empFrame.pack();
        empFrame.setSize(400, 400);
        empFrame.setLocationRelativeTo(null);
        empFrame.setVisible(true);
    }

    public static Vector<String> getPositions(){
        Vector<String> positions = new Vector<>();
        positions.add("Employee");
        positions.add("Supervisor");
        positions.add("Security");
        positions.add("Cleaner");
        positions.add("Manager");
        return positions;
    }
}
