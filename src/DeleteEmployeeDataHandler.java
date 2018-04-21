import java.sql.DriverManager;

public class DeleteEmployeeDataHandler {
    private static java.sql.Connection connection;
    private static java.sql.Statement statement;

    public static void deleteEmployee (String deleteEmployeeID) {
        String deleteEmployeeQuery = "DELETE FROM Employee WHERE ID IN ('" + deleteEmployeeID +"')";

        try{
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(DbCredentials.dbUrl, DbCredentials.dbUsername, DbCredentials.dbPassword);
            statement = connection.createStatement();
            statement.executeUpdate(deleteEmployeeQuery);
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
