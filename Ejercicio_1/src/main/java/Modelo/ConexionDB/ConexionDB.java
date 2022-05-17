package Modelo.ConexionDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class ConexionDB {
	
	private String ip = "192.168.1.40";
    private String ip3 = "localhost";
    private String user = "remote";
    private String password = "Reus_2022";
    private String password2 = "PepitoGrillo2";
    private Connection conexion = null;
    private String bd = "clientevideo";


            public Connection crearConexion() {

                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    conexion = DriverManager.getConnection("jdbc:mysql://" + ip + ":3306/"+ bd +"?useTimezone=true&serverTimezone=UTC", user, password);
                    System.out.println("Conexion establecida.");

                    return conexion;
                } catch (SQLException |ClassNotFoundException e) {
                    System.out.println("No se ha podido conectar.");
                    System.out.println(e);
                    return null;
                }

            }
}