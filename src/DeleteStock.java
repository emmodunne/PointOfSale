import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteStock {

    private JPanel DeleteStockPanel;
    private JTable stockTable;
    private JTextField deleteStockField;
    private JButton deleteButton;
    private JLabel deleteStockLabel;
    private javax.swing.table.DefaultTableModel StockTableModel = new javax.swing.table.DefaultTableModel(){
        boolean[] canEdit = new boolean[]{
                false, false, false, false, false
        };

        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return canEdit[columnIndex];
        }
    };

    public DeleteStock() {
        stockTable.setModel(StockTableModel);
        StockTableModel.setDataVector(CustomerManagementDataHandler.getRows("Stock"),CustomerManagementDataHandler.getTitles("Stock"));

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(deleteStockField.getText().toString().isEmpty()){
                    JOptionPane.showMessageDialog(null, "Delete field cannot be null value", "Error", JOptionPane.ERROR_MESSAGE);
                }else {
                    JOptionPane.showMessageDialog(null, "Successfully deleted stock", "Delete Successful", JOptionPane.INFORMATION_MESSAGE);
                    DeleteStockDataHandler.deleteStock(deleteStockField.getText().toString());
                    stockTable.setModel(StockTableModel);
                    StockTableModel.setDataVector(CustomerManagementDataHandler.getRows("Stock"), CustomerManagementDataHandler.getTitles("Stock"));
                }
            }
        });
    }

    public static void openDeleteStockPanel() {
        JFrame frame = new JFrame("Delete Stock");
        frame.setContentPane(new DeleteStock().DeleteStockPanel);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setSize(500, 600);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
