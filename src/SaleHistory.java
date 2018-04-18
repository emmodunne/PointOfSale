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
                salesLineHistoryTableModel.setDataVector(SaleHistoryDataHandler.getRows(salesIdHistoryList.getSelectedValue().toString()),SaleHistoryDataHandler.getTitles());
            }
        });
    }

    public static void openSalesHistory(){
        salesHistoryFrame = new JFrame("Sale History");
        salesHistoryFrame.setContentPane(new SaleHistory().salesHistoryPanel);
        salesHistoryFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        salesHistoryFrame.pack();
        salesHistoryFrame.setSize(1000, 500);
        salesHistoryFrame.setLocationRelativeTo(null);
        salesHistoryFrame.setVisible(true);
    }
}
