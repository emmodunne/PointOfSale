import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddStock {

    private JPanel addStockPanel;
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
                    JOptionPane.showMessageDialog(addStockFrame, "Barcode cannot be null value", "Error", JOptionPane.ERROR_MESSAGE);
                } else if (descriptionField.getText().toString().isEmpty()) {
                    JOptionPane.showMessageDialog(addStockFrame, "Description cannot be null value", "Error", JOptionPane.ERROR_MESSAGE);
                } else if (quantityField.getText().toString().isEmpty()) {
                    JOptionPane.showMessageDialog(addStockFrame, "Quantity cannot be null value", "Error", JOptionPane.ERROR_MESSAGE);
                } else if (costPriceField.getText().toString().isEmpty()) {
                    JOptionPane.showMessageDialog(addStockFrame, "Cost Price cannot be null value", "Error", JOptionPane.ERROR_MESSAGE);
                } else if (sellingPriceField.getText().toString().isEmpty()) {
                    JOptionPane.showMessageDialog(addStockFrame, "Sell Price cannot be null value", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    AddStockDataHandler.addStock(barcodeField.getText().toString(), descriptionField.getText().toString(), quantityField.getText().toString(), costPriceField.getText().toString(), sellingPriceField.getText().toString());
                    JOptionPane.showMessageDialog(addStockFrame, "Successfully added Stock", "Successfully added Customer", JOptionPane.INFORMATION_MESSAGE);
                    addStockFrame.dispose();
                }
            }

        });
    }

    public static void openAddStockPanel() {
        addStockFrame = new JFrame("Add Stock");
        addStockFrame.setContentPane(new AddStock().addStockPanel);
        addStockFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        addStockFrame.pack();
        addStockFrame.setLocationRelativeTo(null);
        addStockFrame.setVisible(true);
    }
}
