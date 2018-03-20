package DAT;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DATConexion 
{
    //Conectarse a la BDD
    public static Connection con;
    
    public static Connection getConnection() throws SQLException, ClassNotFoundException{
        
            String driver = "com.mysql.jdbc.Driver";
            String url = "jdbc:mysql://localhost:3306/pryrest?zeroDateTimeBehavior=convertToNull";
            Class.forName(driver);
            return DriverManager.getConnection(url,"root","");
    };
    
    public Connection AbrirConexion() throws ClassNotFoundException, SQLException
    {
        con = getConnection();
        return con;
    }
    
    public void CerrarConexion() throws SQLException
    {
       con.close();
    }
}
