import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ContainerAdapter;
import java.awt.event.FocusAdapter;
import java.awt.event.InputMethodListener;

public class SaleHistory {
    private static JFrame salesHistoryFrame;
    private JPanel salesHistoryPanel;
    private JList salesIdHistoryList;
    private JTable salesLinesHistoryTable;
    private JTextField employeeNameText;
    private JTextField customerNameText;
    private JTextField saleTotalText;
    private JTextField paymentMethodText;
    private JTextField amountTenderedText;
    private JTextField changeText;
    private JTextField timeStampText;
    private javax.swing.table.DefaultTableModel salesLineHistoryTableModel = new javax.swing.table.DefaultTableModel(){
        boolean[] canEdit = new boolean[]{
                false, false, false, false
        };

        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return canEdit[columnIndex];
        }
    };

    public SaleHistory() {
        salesIdHistoryList.setModel(new javax.swing.DefaultComboBoxModel(SaleHistoryDataHandler.getSalesIds()));
        salesLinesHistoryTable.setModel(salesLineHistoryTableModel);


        salesIdHistoryList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!salesIdHistoryList.getSelectedValue().toString().isEmpty()) {
                    salesLineHistoryTableModel.setDataVector(SaleHistoryDataHandler.getRows(salesIdHistoryList.getSelectedValue().toString()), SaleHistoryDataHandler.getTitles());
                    String saleInfo[] = SaleHistoryDataHandler.getSalesInfo(salesIdHistoryList.getSelectedValue().toString());
                    timeStampText.setText(saleInfo[0]);
                    employeeNameText.setText(saleInfo[1]);
                    customerNameText.setText(saleInfo[2]);
                    saleTotalText.setText(saleInfo[3]);
                    paymentMethodText.setText(saleInfo[4]);
                    amountTenderedText.setText(saleInfo[5]);
                    changeText.setText(saleInfo[6]);
                }
            }
        });
    }

    public static void openSalesHistory(){
        salesHistoryFrame = new JFrame("Sale History");
        salesHistoryFrame.setContentPane(new SaleHistory().salesHistoryPanel);
        salesHistoryFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        salesHistoryFrame.pack();
        salesHistoryFrame.setSize(700, 400);
        salesHistoryFrame.setLocationRelativeTo(null);
        salesHistoryFrame.setVisible(true);
    }
}
