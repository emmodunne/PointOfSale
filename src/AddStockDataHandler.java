import java.sql.DriverManager;

public class AddStockDataHandler {

    private static java.sql.Connection connection;
    private static java.sql.Statement statement;

    public static void addStock (String barcode, String description, String quantity, String cost, String price) {
        String addStockQuery = "INSERT INTO Stock (Barcode, Description, Qty, Cost, Price) VALUES ('" + barcode +"', '" + description +"', '" + quantity +"', '" + cost +"', '" + price +"')";

        try{
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(DbCredentials.dbUrl, DbCredentials.dbUsername, DbCredentials.dbPassword);
            statement = connection.createStatement();
            statement.executeUpdate(addStockQuery);
        }
        catch ( ClassNotFoundException cnfex ) {
            System.err.println("Issue with driver." );
            cnfex.printStackTrace();
            System.exit( 1 ); // terminate program
        }
        catch ( java.sql.SQLException sqlex ) {
            System.err.println( sqlex );
            sqlex.printStackTrace();
        }
        catch ( Exception ex ) {
            System.err.println( ex );
            ex.printStackTrace();
        }

    }
}
