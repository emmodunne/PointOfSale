import java.sql.DriverManager;

public class SalesDataHandler {
    private static java.sql.Connection connection;
    private static java.sql.Statement statement;
    private static java.sql.ResultSet resultSet;

    public static Object[] getStockLine (String barcode) {
        String sqlQuery = "SELECT Barcode, Description, Price FROM Stock WHERE Barcode = '" + barcode + "'";
        Object [] stockLine = new Object[4];
        try{
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(DbCredentials.dbUrl, DbCredentials.dbUsername, DbCredentials.dbPassword);
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sqlQuery);
            if (resultSet.next()){
                stockLine[0] = 1;
                for(int column = 1; column <= 3; column++) {
                    stockLine[column] = resultSet.getObject(column);
                }
                return stockLine;
            }
            throw new BarcodeNotFoundException("Barcode " + barcode + " not Found");
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
        finally {
            try {
                statement.close();
                resultSet.close();
                connection.close();
            }
            catch (java.sql.SQLException sqlex){
                System.err.println( sqlex );
                sqlex.printStackTrace();
            }
        }
        return null;
    }
}
