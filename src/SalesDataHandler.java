import java.sql.DriverManager;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class SalesDataHandler {
    private static java.sql.Connection connection;
    private static java.sql.Statement statement;
    private static java.sql.ResultSet resultSet;


    public static Vector<Employee> getEmployees() {
        Vector<Employee> employees = new Vector<>();
        String sqlQuery = "SELECT ID, FirstName, LastName FROM Employee";
        try{
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(DbCredentials.dbUrl, DbCredentials.dbUsername, DbCredentials.dbPassword);
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sqlQuery);
            while (resultSet.next()) {
                employees.addElement(new Employee(resultSet.getObject(1).toString(), resultSet.getObject(2).toString() + " " + resultSet.getObject(3).toString()));
            }
            return employees;
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

    public static Vector<Customer> getCustomers() {
        Vector<Customer> customers = new Vector<>();
        customers.addElement(new Customer("0", ""));
        String sqlQuery = "SELECT ID, FirstName, LastName FROM Customers";
        try{
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(DbCredentials.dbUrl, DbCredentials.dbUsername, DbCredentials.dbPassword);
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sqlQuery);
            while (resultSet.next()) {
                customers.addElement(new Customer(resultSet.getObject(1).toString(), resultSet.getObject(2).toString() + " " + resultSet.getObject(3).toString()));
            }
            return customers;
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

    public static void saveSale (String employeeId, String customerId, List<String> salesLines, double total, String paymentMethod, double paymentTendered, double changeDue){
        String sqlQuery = "INSERT INTO Sales (TimeStamp, EmployeeID, CustomerID, Total, PaymentMethod, PaymentTendered, ChangeDue) " +
                "VALUES ('" + new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date()) + "', " + employeeId +", " + customerId + ", "
                + total + ", '" + paymentMethod + "', " + paymentTendered + ", " + changeDue + ")";
        try{
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(DbCredentials.dbUrl, DbCredentials.dbUsername, DbCredentials.dbPassword);
            statement = connection.prepareStatement(sqlQuery);
            statement.executeUpdate(sqlQuery, statement.RETURN_GENERATED_KEYS);
            resultSet = statement.getGeneratedKeys();
            Object saleId = null;
            if (resultSet.next()) {
                saleId = resultSet.getObject(1);
            }
            Iterator<String> salesLinesInterator = salesLines.iterator();
            while (salesLinesInterator.hasNext()) {
                sqlQuery = "INSERT INTO SalesLines (SalesID, StockBarcode) VALUES ('" + saleId  + "', '" + salesLinesInterator.next() + "')";
                statement = connection.createStatement();
                statement.executeUpdate(sqlQuery);
            }
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
    }
}
