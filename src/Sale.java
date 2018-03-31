import javax.swing.*;

public class Sale {
    private JButton worksButton;
    private JPanel panel1;

    public static void openSales(){
        JFrame frame = new JFrame("Sale");
        frame.setContentPane(new Sale().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
