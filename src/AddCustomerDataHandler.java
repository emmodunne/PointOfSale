import java.sql.DriverManager;

/**
 * Created by jonat on 03/04/2018.
 */
public class AddCustomerDataHandler {
    private static java.sql.Connection connection;
    private static java.sql.Statement statement;

    public static int addCustomer (String firstName, String lastName, String phoneNum) {
        String sqlQuery = "INSERT INTO Customers (FirstName, LastName, PhoneNumber) VALUES ('" + firstName +"', '" + lastName +"', '" + phoneNum +"')";

        try{
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(DbCredentials.dbUrl, DbCredentials.dbUsername, DbCredentials.dbPassword);
            statement = connection.createStatement();
            return(statement.executeUpdate(sqlQuery));
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
        return -1;
    }

}
