import java.sql.DriverManager;

/**
 * Created by jonat on 17/04/2018.
 */
public class DeleteCustomerDataHandler {

        private static java.sql.Connection connection;
        private static java.sql.Statement statement;

        public static void deleteCustomer (String deleteCustomerID) {
            //TODO Create correct delete statement and then replicate in all classes
            String deleteCustomerQuery = "DELETE FROM Customers WHERE ID IN ('" + deleteCustomerID +"')";
            System.out.println(deleteCustomerQuery);

            try{
                Class.forName("com.mysql.jdbc.Driver");
                connection = DriverManager.getConnection(DbCredentials.dbUrl, DbCredentials.dbUsername, DbCredentials.dbPassword);
                statement = connection.createStatement();
                statement.executeUpdate(deleteCustomerQuery);
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
