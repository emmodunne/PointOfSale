import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Vector;

public class SaleHistoryDataHandler {
    private static java.sql.Connection connection;
    private static java.sql.Statement statement;
    private static java.sql.ResultSet resultSet;
    private static java.sql.ResultSetMetaData rsMeta;
    private static int columnCount;

    public static Vector<String> getSalesIds() {
        Vector<String> salesIds = new Vector<>();
        String sqlQuery = "SELECT ID FROM Sales ORDER BY ID DESC";
        try{
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(DbCredentials.dbUrl, DbCredentials.dbUsername, DbCredentials.dbPassword);
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sqlQuery);
            while (resultSet.next()) {
                salesIds.add(resultSet.getObject(1).toString());
            }
            return salesIds;
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


        public static void searchRecords(String saleID) {
            String sqlQuery = "SELECT Stock.Barcode, Stock.Description, Stock.Price FROM SalesLines, Sales, Stock " +
                    "WHERE  Sales.ID = " + saleID + " AND SalesLines.SalesID = Sales.ID AND SalesLines.StockBarcode = Stock.Barcode";
            try{
                Class.forName("com.mysql.jdbc.Driver");
                connection = DriverManager.getConnection(DbCredentials.dbUrl, DbCredentials.dbUsername, DbCredentials.dbPassword);
                statement = connection.createStatement(
                        java.sql.ResultSet.TYPE_SCROLL_INSENSITIVE,
                        ResultSet.CONCUR_READ_ONLY);
                resultSet = statement.executeQuery(sqlQuery);
                rsMeta = resultSet.getMetaData();
                columnCount = rsMeta.getColumnCount();

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

        public static Object[] getTitles() {
            Object [] columnNames = new Object[columnCount];
            try{
                for(int col = columnCount; col > 0; col--) {
                    columnNames[col - 1] = (String)rsMeta.getColumnName(col);
                }
            }
            catch( java.sql.SQLException sqlex ) {
                System.err.println( sqlex );
                sqlex.printStackTrace();
            }

            return columnNames;
        }

        public static Object[][] getRows(String saleID) {
            searchRecords(saleID);
            Object [][] content;
            try{
                // determine the number of rows
                resultSet.last();
                int number = resultSet.getRow();
                content = new Object[number][columnCount];
                resultSet.beforeFirst();

                int i =0;
                while(resultSet.next()) {
                    // each row is an array of objects
                    for(int col = 1; col <= columnCount; col++)
                        content[i][col - 1] = resultSet.getObject(col);
                    i++;
                }
                return content;
            }
            catch( java.sql.SQLException sqlex ) {
                System.err.println( sqlex );
                sqlex.printStackTrace();
            }
            return null;
        }

    public static String[] getSalesInfo(String saleId) {
        String sqlQuery = "SELECT COUNT(*) FROM Sales WHERE ID = '" + saleId + "' AND CustomerID IS NULL";
        try{
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(DbCredentials.dbUrl, DbCredentials.dbUsername, DbCredentials.dbPassword);
            statement = connection.createStatement(java.sql.ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            resultSet = statement.executeQuery(sqlQuery);
            resultSet.first();
                if (resultSet.getObject(1).toString().equals("1") ){
                    sqlQuery = "SELECT Sales.TimeStamp, Employee.FirstName as EmployeeFirstName, Employee.LastName as EmployeeLastName, " +
                            " Sales.Total, Sales.PaymentMethod, Sales.PaymentTendered, Sales.ChangeDue " +
                            "FROM Sales, Employee WHERE Sales.ID = " + saleId + " AND EmployeeID = Employee.ID";
                    resultSet = statement.executeQuery(sqlQuery);
                    resultSet.first();
                    return new String[]{resultSet.getObject(1).toString(), resultSet.getObject(2).toString() + " " + resultSet.getObject(3).toString(), " ", resultSet.getObject(4).toString(), resultSet.getObject(5).toString(), resultSet.getObject(7).toString(), resultSet.getObject(7).toString()};
                } else {
                    sqlQuery = "SELECT Sales.TimeStamp, Employee.FirstName as EmployeeFirstName, Employee.LastName as EmployeeLastName, " +
                            "Customers.FirstName as CustomerFirstName, Customers.LastName as CustomerLastName, Sales.Total, Sales.PaymentMethod, Sales.PaymentTendered, Sales.ChangeDue " +
                            "FROM Sales, Employee, Customers WHERE Sales.ID = " + saleId + " AND EmployeeID = Employee.ID AND CustomerID = Customers.ID";
                    resultSet = statement.executeQuery(sqlQuery);
                    resultSet.first();
                    return new String[]{resultSet.getObject(1).toString(), resultSet.getObject(2).toString() + " " + resultSet.getObject(3).toString(), resultSet.getObject(4).toString() + " " + resultSet.getObject(5).toString(), resultSet.getObject(6).toString(), resultSet.getObject(7).toString(), resultSet.getObject(8).toString(), resultSet.getObject(9).toString()};
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
        return null;
    }

}

