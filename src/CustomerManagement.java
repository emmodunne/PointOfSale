import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomerManagement {
    private JPanel CustomerManagementPanel;
    private JButton buttoAddCustomerBUttonn1;

    public CustomerManagement() {
        buttoAddCustomerBUttonn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddCustomer.openAddCustomerPanel();
            }
        });
    }

    public static void openCustomerMangementPanel() {
        JFrame frame = new JFrame("Customer Mangement");
        frame.setContentPane(new CustomerManagement().CustomerManagementPanel);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setSize(1000, 500);
        frame.setVisible(true);
    }
}
