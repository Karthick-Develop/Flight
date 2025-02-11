package book;

import java.sql.Connection;
import java.sql.DriverManager;
public class MyConnection {
    public static Connection getConnection()
    {
        Connection con = null;
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/flight","root","Apple2002@");
        }
        catch(Exception ex)
        {
            System.out.println(ex);
        }
        return con;
        
    }
    
}

