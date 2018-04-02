import javax.swing.*;

public class CustomerManagement {
    private JPanel CustomerManagementPanel;

    public static void openCustomerMangementPanel() {
        JFrame frame = new JFrame("Customer Mangement");
        frame.setContentPane(new CustomerManagement().CustomerManagementPanel);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setSize(1000, 500);
        frame.setVisible(true);
    }
}
