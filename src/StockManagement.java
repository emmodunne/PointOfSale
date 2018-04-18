import javax.swing.*;

public class StockManagement {
    private JPanel StockManagementPanel;

    public static void openStockManagementPanel() {
        JFrame frame = new JFrame("Stock Management");
        frame.setContentPane(new StockManagement().StockManagementPanel);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setSize(500, 600);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
