import java.sql.DriverManager;

/**
 * Created by jonat on 21/04/2018.
 */
public class StockManagementDataHandler {


    private static java.sql.Connection connection;
    private static java.sql.Statement statement;
    private static java.sql.ResultSet resultSet;
    private static java.sql.ResultSetMetaData rsMeta;
    private static int columnCount;

    public static void searchRecords(String table) {
        String sqlQuery = "SELECT * FROM " + table;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(DbCredentials.dbUrl, DbCredentials.dbUsername, DbCredentials.dbPassword);
            statement = connection.createStatement(
                    java.sql.ResultSet.TYPE_SCROLL_INSENSITIVE,
                    java.sql.ResultSet.CONCUR_UPDATABLE);
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

    public static Object[] getTitles(String table) {
        Object [] columnNames = new Object[columnCount];
        try{
            for(int col = columnCount; col > 0; col--) {
                columnNames[col - 1] =(String)rsMeta.getColumnName(col);
                System.out.println(col - 1);
                System.out.println(columnNames[col - 1]);
            }
        }
        catch( java.sql.SQLException sqlex ) {
            System.err.println( sqlex );
            sqlex.printStackTrace();
        }
        System.out.println(columnNames[1]);

        return columnNames;
    }

    public static Object[][] getRows(String table) {
        searchRecords(table);
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
}
