package resources;
import java.sql.*;

public class ConnectionDB {
    public static Connection connectionDB(){
        String url="www.ejemplo.com:3306/bd_ds";
        String user="user";
        String pass="123";
        String remoteConnection ="jdbc:mysql://"+url+","+user+","+pass;
        try{
            Connection cn=DriverManager.getConnection("jdbc:mysql://localhost/hostelData","root","");
            return cn;
            
        }catch(SQLException e){
            System.err.println("Database connection error: "+e);
        }
           return(null);
    }

}

