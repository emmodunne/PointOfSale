import java.sql.DriverManager;

/**
 * Created by jonat on 18/04/2018.
 */
public class AddEmployeeDataHandler {

    private static java.sql.Connection connection;
    private static java.sql.Statement statement;

    public static void addEmployee (String firstName, String lastName, String phoneNum, String email) {
        String addEmployeeQuery = "INSERT INTO Employee (FirstName, LastName, Position, ContactEmail) VALUES ('" + firstName +"', '" + lastName +"', '" + phoneNum +"', '" + email +"')";

        try{
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(DbCredentials.dbUrl, DbCredentials.dbUsername, DbCredentials.dbPassword);
            statement = connection.createStatement();
            statement.executeUpdate(addEmployeeQuery);
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
