package mx.uv.c80640;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private static String url = "jdbc:mysql://127.0.0.1:3306/Sistemas_web";
    private static String DriverName = "com.mysql.jdbc.Driver";
    private static String username = "moonCake";
    private static String password = "123456";
    private static Connection connection = null;
    
    public static Connection getConnection(){
        try{
            Class.forName(DriverName);
            connection = DriverManager.getConnection(url, username, password);
        }catch(SQLException e){
            System.out.println(e);
        }catch(ClassNotFoundException c){
            System.out.println("No se encontró el driver");
        }
        return connection;
    }
    
}
