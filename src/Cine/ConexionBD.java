package Cine;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ConexionBD 
{
    Connection con;
    
    public ConexionBD()
    {}
    
    public Connection getConectar()
    {
        con = null;
        
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cine", "root", "");
        }
        catch(ClassNotFoundException | SQLException e)
        {
            JOptionPane.showMessageDialog(null,"Existe un error: " + e,"Conexion BD", 2);
            con = null;
        }       
        return con;
    }
    
    public Connection getDesconectar()
    {
       con = null;
       return null;
    }   
}
