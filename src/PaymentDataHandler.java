import java.sql.DriverManager;
import java.sql.Statement;

public class PaymentDataHandler {
    private static java.sql.Connection connection;
    private static java.sql.Statement statement;
    private static java.sql.ResultSet resultSet;

    public static void insertSaleRecord (String studentFirstName, String studentLastName, String studentContactEmail, int score) {
        String sqlQuery = "INSERT INTO Student (FirstName, LastName, ContactEmail) VALUES ('" + studentFirstName +"', '" + studentLastName +"', '" + studentContactEmail +"')";

        try{
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(DbCredentials.dbUrl, DbCredentials.dbUsername, DbCredentials.dbPassword);
            statement = connection.prepareStatement(sqlQuery);
            statement.executeUpdate(sqlQuery, Statement.RETURN_GENERATED_KEYS);
            resultSet = statement.getGeneratedKeys();
            Object studentId = null;
            if (resultSet.next()) {
                studentId = resultSet.getObject(1);
            }
            sqlQuery = "INSERT INTO Quiz (Score, StudentId) VALUES ('" + score +"', '" + studentId + "')";
            statement = connection.createStatement();
            statement.executeUpdate(sqlQuery);
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
