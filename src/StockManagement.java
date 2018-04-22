import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StockManagement {
    private JPanel stockManagementPanel;
    private JTable stockManagementTable;
    private JButton removeStockButton;
    private JButton addStockButton;
    private static JFrame stockMangFrame;
    private javax.swing.table.DefaultTableModel StockTableModel = new javax.swing.table.DefaultTableModel(){
        boolean[] canEdit = new boolean[]{
                false, false, false, false, false
        };

        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return canEdit[columnIndex];
        }
    };


    public StockManagement() {
        stockManagementTable.setModel(StockTableModel);
        StockTableModel.setDataVector(StockManagementDataHandler.getRows("Stock"),StockManagementDataHandler.getTitles("Stock"));

        addStockButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                AddStock.openAddStockPanel();
            }
        });
        removeStockButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DeleteStock.openDeleteStockPanel();
                stockMangFrame.dispose();
            }
        });
    }

    public static void openStockManagementPanel() {
        stockMangFrame = new JFrame("Stock Management");
        stockMangFrame.setContentPane(new StockManagement().stockManagementPanel);
        stockMangFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        stockMangFrame.pack();
        stockMangFrame.setSize(500, 600);
        stockMangFrame.setLocationRelativeTo(null);
        stockMangFrame.setVisible(true);
    }
}
