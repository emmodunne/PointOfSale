import javax.swing.*;
import java.awt.event.*;
import java.awt.print.PrinterException;
import java.text.MessageFormat;
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
    private javax.swing.table.DefaultTableModel salesLinesTableModel =
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
        SalesLinesTable.setModel(salesLinesTableModel);
        String[] SalesLinesColumnNames = {"QTY", "Barcode", "Description", "Price (€)"};
        salesLinesTableModel.setColumnIdentifiers(SalesLinesColumnNames);
        employeeCombo.setModel(new javax.swing.DefaultComboBoxModel(SalesDataHandler.getEmployees()));
        customerCombo.setModel(new javax.swing.DefaultComboBoxModel(SalesDataHandler.getCustomers()));
        saleFrame.getRootPane().setDefaultButton(enterButton);
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
                    for (int count = 0; count < salesLinesTableModel.getRowCount(); count++) {
                        salesLines.add(salesLinesTableModel.getValueAt(count, 1).toString());
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
                    int response = JOptionPane.showConfirmDialog(saleFrame, String.format ("Sale Total: €%.2f\nAmount Tendered: €%.2f\nChange Due: €%.2f\n\n Is a Receipt Required?", saleTotal, amountTendered, changeDue), "Sale Complete - Receipt Required?", JOptionPane.YES_NO_OPTION);
                    if (response == 0){
                        MessageFormat header = new MessageFormat("Sales Receipt");
                        MessageFormat footer = new MessageFormat(String.format ("Sale Total: €%.2f | Amount Tendered: €%.2f | Change Due: €%.2f", saleTotal, amountTendered, changeDue));
                        try {
                            SalesLinesTable.print(JTable.PrintMode.FIT_WIDTH, header, footer);
                        } catch (PrinterException e1) {
                            e1.printStackTrace();
                        }
                    }
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
                   salesLinesTableModel.insertRow(salesLinesTableModel.getRowCount(), stockLineReturned);
                   saleTotal += Double.parseDouble(stockLineReturned[3].toString());
                   salesTotalText.setText(String.format ("€%.2f", saleTotal));
                   amountTenderedText.setText(String.format ("%.2f", saleTotal));
                }
                else {
                    JOptionPane.showMessageDialog(saleFrame, "Barcode not Found", "Barcode not Found", JOptionPane.ERROR_MESSAGE);
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
        saleFrame.setSize(800, 400);
        saleFrame.setLocationRelativeTo(null);
        saleFrame.setVisible(true);
    }



}
