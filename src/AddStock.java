import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddStock {

    private JPanel AddStockPanel;
    private JTextField barcodeField;
    private JTextField descriptionField;
    private JTextField quantityField;
    private JTextField costPriceField;
    private JTextField sellingPriceField;
    private JLabel barcodeLabel;
    private JLabel descriptionLabel;
    private JLabel quantityLabel;
    private JLabel costPriceLabel;
    private JLabel sellingPriceLabel;
    private JButton addButton;
    private static JFrame addStockFrame;

    public AddStock(){
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                if (barcodeField.getText().toString().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "First name cannot be null value", "Error", JOptionPane.ERROR_MESSAGE);
                } else if (descriptionField.getText().toString().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Last name cannot be null value", "Error", JOptionPane.ERROR_MESSAGE);
                } else if (quantityField.getText().toString().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Phone number cannot be null value", "Error", JOptionPane.ERROR_MESSAGE);
                } else if (costPriceField.getText().toString().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Last name cannot be null value", "Error", JOptionPane.ERROR_MESSAGE);
                } else if (sellingPriceField.getText().toString().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Phone number cannot be null value", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Successfully added customer", "Added", JOptionPane.INFORMATION_MESSAGE);
                    AddStockDataHandler.addStock(barcodeField.getText().toString(), descriptionField.getText().toString(), quantityField.getText().toString(), costPriceField.getText().toString(), sellingPriceField.getText().toString());
                    StockManagement.openStockManagementPanel();
                    addStockFrame.dispose();
                }
            }

        });
    }

    public static void openAddStockPanel() {
        addStockFrame = new JFrame("Add Stock");
        addStockFrame.setContentPane(new AddStock().AddStockPanel);
        addStockFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        addStockFrame.pack();
        addStockFrame.setSize(400, 400);
        addStockFrame.setLocationRelativeTo(null);
        addStockFrame.setVisible(true);
    }
}
