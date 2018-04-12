import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Sale {
    private JPanel SalePanel;
    private JTextField BarcodeTextField;
    private JButton EnterButton;
    private JTable SalesLinesTable;
    private JTextField TotalTextField;
    private JButton TenderPaymentButton;
    private JLabel InputBarcodeLabel;
    private JLabel TotalLabel;
    private javax.swing.table.DefaultTableModel SalesLinesTableModel =
            new javax.swing.table.DefaultTableModel(0,4);

    public Sale() {
        SalesLinesTable.setModel(SalesLinesTableModel);
        String[] SalesLinesColumnNames = {"QTY", "Barcode", "Description", "Price"};
        SalesLinesTableModel.setColumnIdentifiers(SalesLinesColumnNames);
        TenderPaymentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Payment.openPaymentScreen();
            }
        });
        EnterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object[] stockLineReturned = null;
                stockLineReturned = SalesDataHandler.getStockLine(BarcodeTextField.getText().toString());
               if (stockLineReturned != null){
                   SalesLinesTableModel.insertRow(SalesLinesTableModel.getRowCount(), stockLineReturned);
               }
            }
        });
    }

    public static void openSales(){
        JFrame frame = new JFrame("Sale");
        frame.setContentPane(new Sale().SalePanel);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setSize(1000, 500);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
