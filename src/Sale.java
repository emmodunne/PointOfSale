import javax.swing.*;

public class Sale {
    private JPanel SalePanel;

    public static void openSales(){
        JFrame frame = new JFrame("Sale");
        frame.setContentPane(new Sale().SalePanel);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setSize(1000, 500);
        frame.setVisible(true);
    }
}
