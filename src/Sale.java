
import javax.swing.*;
import java.awt.event.*;
import java.text.DecimalFormat;


public class Sale {
    private JPanel SalePanel;
    private JTextField barcodeText;
    private JButton enterButton;
    private JTable SalesLinesTable;
    private JTextField salesTotalText;
    private JButton tenderPaymentButton;
    private JLabel inputBarcodeLabel;
    private JLabel totalLabel;
    private javax.swing.table.DefaultTableModel SalesLinesTableModel =
            new javax.swing.table.DefaultTableModel(0,4);
    private static DecimalFormat decimalFormat = new DecimalFormat(".##");
    private double saleTotal = 0;

    public Sale() {
        SalesLinesTable.setModel(SalesLinesTableModel);
        String[] SalesLinesColumnNames = {"QTY", "Barcode", "Description", "Price (€)"};
        SalesLinesTableModel.setColumnIdentifiers(SalesLinesColumnNames);
        tenderPaymentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Payment.openPaymentScreen(saleTotal);
            }
        });
        enterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object[] stockLineReturned = null;
                stockLineReturned = SalesDataHandler.getStockLine(barcodeText.getText().toString());
               if (stockLineReturned != null){
                   SalesLinesTableModel.insertRow(SalesLinesTableModel.getRowCount(), stockLineReturned);
                   saleTotal += Double.parseDouble(stockLineReturned[3].toString());
                   salesTotalText.setText(String.format ("€%.2f", saleTotal));
               }
               barcodeText.setText(null);
               barcodeText.requestFocus();
            }
        });
        tenderPaymentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });
    }

    public static void openSales() {
        JFrame frame = new JFrame("Sale");
        frame.setContentPane(new Sale().SalePanel);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                MainMenu.setSaleOpen(false);
            }
        });
        frame.pack();
        frame.setSize(800, 400);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }



}
