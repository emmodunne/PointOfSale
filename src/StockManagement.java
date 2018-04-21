import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StockManagement {
    private JPanel StockManagementPanel;
    private JTable StockManagementTable;
    private JButton RemoveStockButton;
    private JButton AddStockButton;
    private static JFrame stockMangFrame;
    private javax.swing.table.DefaultTableModel StockTableModel = new javax.swing.table.DefaultTableModel();


    public StockManagement() {
        StockManagementTable.setModel(StockTableModel);
        StockTableModel.setDataVector(CustomerManagementDataHandler.getRows("Stock"),CustomerManagementDataHandler.getTitles("Stock"));

        AddStockButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                AddStock.openAddStockPanel();
                stockMangFrame.dispose();
            }
        });
        RemoveStockButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               // DeleteStock.openDeleteStockPanel();
                stockMangFrame.dispose();
            }
        });
    }

    public static void openStockManagementPanel() {
        stockMangFrame = new JFrame("Stock Management");
        stockMangFrame.setContentPane(new StockManagement().StockManagementPanel);
        stockMangFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        stockMangFrame.pack();
        stockMangFrame.setSize(500, 600);
        stockMangFrame.setLocationRelativeTo(null);
        stockMangFrame.setVisible(true);
    }
}
