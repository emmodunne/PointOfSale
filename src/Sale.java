
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;


public class Sale {
    private static JFrame saleFrame;
    private JPanel SalePanel;
    private JTextField barcodeText;
    private JButton enterButton;
    private JTable SalesLinesTable;
    private JTextField salesTotalText;
    private JButton tenderPaymentButton;
    private JLabel inputBarcodeLabel;
    private JLabel totalLabel;
    private JRadioButton cashRadioButton;
    private JRadioButton cardRadioButton;
    private JTextField amountTenderedText;
    private JComboBox employeeCombo;
    private JComboBox customerCombo;
    private JLabel employeeLabel;
    private JLabel customerLabel;
    private javax.swing.table.DefaultTableModel SalesLinesTableModel =
            new javax.swing.table.DefaultTableModel(0,4){
                boolean[] canEdit = new boolean[]{
                        false, false, true, false
                };

                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return canEdit[columnIndex];
                }
            };
    private double saleTotal = 0;

    public Sale() {
        SalesLinesTable.setModel(SalesLinesTableModel);
        String[] SalesLinesColumnNames = {"QTY", "Barcode", "Description", "Price (€)"};
        SalesLinesTableModel.setColumnIdentifiers(SalesLinesColumnNames);
        employeeCombo.setModel(new javax.swing.DefaultComboBoxModel(SalesDataHandler.getEmployees()));
        customerCombo.setModel(new javax.swing.DefaultComboBoxModel(SalesDataHandler.getCustomers()));
        saleFrame.getRootPane().setDefaultButton(enterButton);
        barcodeText.requestFocus();
        cardRadioButton.setSelected(true);
        tenderPaymentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (SalesLinesTable.getRowCount() == 0){
                    JOptionPane.showMessageDialog(saleFrame, "There are no lines in the current sale", "Unable to Tender Sale", JOptionPane.ERROR_MESSAGE);
                }
                else {
                    if (amountTenderedText.getText().isEmpty()){
                        amountTenderedText.setText(String.valueOf(saleTotal));
                    }
                    List<String> salesLines = new ArrayList<>();
                    for (int count = 0; count < SalesLinesTableModel.getRowCount(); count++) {
                        salesLines.add(SalesLinesTableModel.getValueAt(count, 1).toString());
                    }
                    double amountTendered = Double.parseDouble(amountTenderedText.getText());
                    double changeDue = amountTendered - saleTotal;
                    Employee employee = (Employee) employeeCombo.getSelectedItem();
                    Customer customer = (Customer) customerCombo.getSelectedItem();
                    if (cashRadioButton.isSelected()) {
                        SalesDataHandler.saveSale(employee.getId(), ((customer.getId().equals("0")) ? null : customer.getId()), salesLines, saleTotal, "Cash", amountTendered, changeDue);
                    }
                    else {
                        SalesDataHandler.saveSale(employee.getId(), ((customer.getId().equals("0")) ? null : customer.getId()), salesLines, saleTotal, "Card", amountTendered, changeDue);
                    }
                    JOptionPane.showMessageDialog(saleFrame, String.format ("Sale Total: €%.2f\nAmount Tendered: €%.2f\nChange Due: €%.2f", saleTotal, amountTendered, changeDue), "Sale Complete", JOptionPane.INFORMATION_MESSAGE);
                    saleFrame.dispose();
                    Sale.openSales();
                }
            }
        });
        enterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object[] stockLineReturned;
                stockLineReturned = SalesDataHandler.getStockLine(barcodeText.getText().toString());
               if (stockLineReturned != null){
                   SalesLinesTableModel.insertRow(SalesLinesTableModel.getRowCount(), stockLineReturned);
                   saleTotal += Double.parseDouble(stockLineReturned[3].toString());
                   salesTotalText.setText(String.format ("€%.2f", saleTotal));
                   amountTenderedText.setText(String.format ("%.2f", saleTotal));
               }
               barcodeText.setText(null);
               barcodeText.requestFocus();
            }
        });
        cashRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                amountTenderedText.requestFocus();
            }
        });
        cardRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                amountTenderedText.requestFocus();
            }
        });
        customerCombo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                barcodeText.requestFocus();
            }
        });
    }

    public static void openSales() {
        saleFrame = new JFrame("Sale");
        saleFrame.setContentPane(new Sale().SalePanel);
        saleFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        saleFrame.pack();
        saleFrame.setAlwaysOnTop(true);
        saleFrame.setSize(800, 400);
        saleFrame.setLocationRelativeTo(null);
        saleFrame.setVisible(true);
    }



}
