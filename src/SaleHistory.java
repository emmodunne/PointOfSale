import javax.swing.*;

public class SaleHistory {
    private JPanel SaleHistoryPanel;

    public static void openSalesHistory(){
        JFrame frame = new JFrame("Sale History");
        frame.setContentPane(new SaleHistory().SaleHistoryPanel);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setSize(1000, 500);
        frame.setVisible(true);
    }
}
