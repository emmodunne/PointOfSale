import java.sql.DriverManager;

public class DeleteStockDataHandler {
    private static java.sql.Connection connection;
    private static java.sql.Statement statement;

    public static void deleteStock (String deleteStockBarcode) {
        String deleteStockQuery = "DELETE FROM Stock WHERE Barcode IN ('" + deleteStockBarcode +"')";

        try{
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(DbCredentials.dbUrl, DbCredentials.dbUsername, DbCredentials.dbPassword);
            statement = connection.createStatement();
            statement.executeUpdate(deleteStockQuery);
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
