import javax.swing.*;

public class StockManagement {
    private JPanel StockManagementPanel;

    public static void openStockManagementPanel() {
        JFrame frame = new JFrame("Stock Management");
        frame.setContentPane(new StockManagement().StockManagementPanel);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setSize(1000, 500);
        frame.setVisible(true);
    }
}
