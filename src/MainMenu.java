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
//        frame.setContentPane(new MainMenu().MainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public MainMenu() {
//        saleButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                JFrame frame = new JFrame("Sale");
//                frame.setContentPane(new Sale().);
//                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//                frame.pack();
//                frame.setVisible(true);
//            }
//        });
//        saleHistoryButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//
//            }
//        });
//        customerManagementButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//
//            }
//        });
//        stockManagementButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//
//            }
//        });
//        employeeManagementButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//
//            }
//        });
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
