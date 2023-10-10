package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {

    Connection con;
    String url = "jdbc:mysql://localhost:3306/bd_ventas";
    String user = "root";
    String pass = "123456";
    public Connection Conexion(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, pass);
            System.out.println("Se conecto esta wea");
        } catch (Exception ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex+ " No se conecto");
        }
        return con;
    }
    
    
}
