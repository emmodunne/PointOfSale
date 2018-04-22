import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteStock {

    private static JFrame delStockFrame;
    private JPanel deleteStockPanel;
    private JTable stockTable;
    private JTextField deleteStockField;
    private JButton deleteButton;
    private JLabel deleteStockLabel;
    private javax.swing.table.DefaultTableModel stockTableModel = new javax.swing.table.DefaultTableModel(){
        boolean[] canEdit = new boolean[]{
                false, false, false, false, false
        };

        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return canEdit[columnIndex];
        }
    };

    public DeleteStock() {
        stockTable.setModel(stockTableModel);
        stockTableModel.setDataVector(CustomerManagementDataHandler.getRows("Stock"),CustomerManagementDataHandler.getTitles("Stock"));
        delStockFrame.getRootPane().setDefaultButton(deleteButton);
        deleteStockField.requestFocus();
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(deleteStockField.getText().toString().isEmpty()){
                    JOptionPane.showMessageDialog(null, "Delete field cannot be null value", "Error", JOptionPane.ERROR_MESSAGE);
                }else {
                    DeleteStockDataHandler.deleteStock(deleteStockField.getText().toString());
                    JOptionPane.showMessageDialog(delStockFrame, "Successfully deleted Stock", "Successfully deleted Stock", JOptionPane.INFORMATION_MESSAGE);
                    stockTable.setModel(stockTableModel);
                    stockTableModel.setDataVector(CustomerManagementDataHandler.getRows("Stock"), CustomerManagementDataHandler.getTitles("Stock"));
                    deleteStockField.setText(null);
                    deleteStockField.requestFocus();
                }
            }
        });
    }

    public static void openDeleteStockPanel() {
        delStockFrame = new JFrame("Delete Stock");
        delStockFrame.setContentPane(new DeleteStock().deleteStockPanel);
        delStockFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        delStockFrame.pack();
        delStockFrame.setSize(500, 600);
        delStockFrame.setLocationRelativeTo(null);
        delStockFrame.setVisible(true);
    }
}
