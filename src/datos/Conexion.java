
package datos;
import java.sql.*;


public class Conexion
{
    private static String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static String JDBC_URL = "jdbc:mysql://localhost:3306/sga?useSSL=false";
    private static String JDBC_ROOT = "root";
    private static String JDBC_PASS = "Catalina";
    private static Driver driver = null;
    
    public static synchronized Connection getConnection() throws SQLException
    {
        if (driver == null)
        {
            try 
            {
                Class jdbcDriverClass = Class.forName(JDBC_DRIVER);
                driver = (Driver)jdbcDriverClass.newInstance();
                DriverManager.registerDriver(driver);               
                
            }//try
            catch(Exception e)
            {
                System.out.println("Fallo al cargar el driver");
                e.printStackTrace();
            }//catch
        }//if
        return DriverManager.getConnection(JDBC_URL,JDBC_ROOT,JDBC_PASS);
        
    }//getConnection
    
    public static void close(ResultSet rs)
    {
        try
        {
            if (rs != null)
            {
                rs.close();
            }//if
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        
        }
    }//close ResultSet
    
    public static void close (PreparedStatement stmt)
    {
        try
        {
            if (stmt != null)
            {
                stmt.close();
            }//if
        }//try
        catch(SQLException e)
        {
            e.printStackTrace();
        }//catch
        
    }//close stmt
    
    public static void close (Connection conn)
    {
        try
        {
            if (conn != null)
            {
                conn.close();
            }//
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }//catch
    }//close Connection
}//conexion
