import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class AddEmployee {
    private JPanel addEmployeePanel;
    private JTextField firstNameField;
    private JTextField lastNameField;
    private JComboBox positionComboBox;
    private JTextField emailField;
    private JButton addButton;
    private static JFrame addEmpFrame;


    public AddEmployee() {
        positionComboBox.setModel(new javax.swing.DefaultComboBoxModel(getPositions()));
        addEmpFrame.getRootPane().setDefaultButton(addButton);
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(firstNameField.getText().toString().isEmpty()){
                    JOptionPane.showMessageDialog(addEmpFrame, "First name cannot be null value", "Error", JOptionPane.ERROR_MESSAGE);
                }
                else if(lastNameField.getText().toString().isEmpty()){
                    JOptionPane.showMessageDialog(addEmpFrame, "Last name cannot be null value", "Error", JOptionPane.ERROR_MESSAGE);
                }
                else if(positionComboBox.getSelectedItem().toString().isEmpty()){
                    JOptionPane.showMessageDialog(addEmpFrame, "Position cannot be null value", "Error", JOptionPane.ERROR_MESSAGE);
                }
                else if(emailField.getText().toString().isEmpty()){
                    JOptionPane.showMessageDialog(addEmpFrame, "Email Address cannot be null value", "Error", JOptionPane.ERROR_MESSAGE);
                }
                else{
                    AddEmployeeDataHandler.addEmployee(firstNameField.getText().toString(), lastNameField.getText().toString(), positionComboBox.getSelectedItem().toString(), emailField.getText().toString());
                    JOptionPane.showMessageDialog(addEmpFrame, "Successfully added Employee", "Employee Added" , JOptionPane.INFORMATION_MESSAGE);
                    addEmpFrame.dispose();
                }
            }
        });
    }

    public static void openAddEmployeepanel() {
        addEmpFrame = new JFrame("Add Employee");
        addEmpFrame.setContentPane(new AddEmployee().addEmployeePanel);
        addEmpFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        addEmpFrame.pack();
        addEmpFrame.setLocationRelativeTo(null);
        addEmpFrame.setVisible(true);
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
