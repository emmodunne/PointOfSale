import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by jonat on 31/03/2018.
 */
public class MainMenu extends Container {
    private JPanel MainPanel;
    private JButton stockManagementButton;
    private JButton customerManagementButton;
    private JButton saleHistoryButton;
    private JButton saleButton;
    private JButton employeeManagementButton;

    public static void main(String[] args) {
        JFrame frame = new JFrame("MainMenu");
        frame.setContentPane(new MainMenu().MainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(500, 600);
        frame.setVisible(true);
    }

    public MainMenu() {
        saleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Sale.openSales();
            }
        });
        saleHistoryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SaleHistory.openSalesHistory();
            }
        });
        customerManagementButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CustomerManagement.openCustomerMangementPanel();
            }
        });
        stockManagementButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StockManagement.openStockManagementPanel();
            }
        });
        employeeManagementButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EmployeeManagement.openEmployeeManagementPanel();
            }
        });
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
