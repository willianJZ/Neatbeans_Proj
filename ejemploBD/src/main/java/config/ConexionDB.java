package config;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDB {


    public static  Connection getConexion() {
        // Datos de conexión
        // Cambia por tu nombre de base de datos
        String url = "jdbc:mysql://localhost:3306/mi_pcseguro";
        // Cambia por tu usuario de la base de datos
        String usuario = "root";
        // Cambia por tu contraseña de la base de datos
        String clave = "";

        // Intentar establecer la conexión
        Connection conexion = null;


        try {
            System.out.println("Estableciendo conexion....");
            /*Eliminar -> Connection*/
            conexion = DriverManager.getConnection(url, usuario, clave);
            System.out.println("¡Conexión exitosa!");
            //conexion.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al conectar a la base de datos: " + e.getMessage());
        }


        // Devuelve el objeto conexion
        return conexion;

    }

    public void closeConexion(Connection conexion) {

        try {
            if (conexion != null) {
                conexion.close();
                System.out.println("Conexión cerrada.");
            }
        } catch (SQLException e) {
            System.err.println("Error al cerrar la conexión: " + e.getMessage());
        }

    }
}