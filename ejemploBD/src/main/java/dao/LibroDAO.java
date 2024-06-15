package dao;


import config.ConexionDB;
import model.Libro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LibroDAO {
     private  final Connection conexion;
     private final ConexionDB conexionDB;

     public  LibroDAO(){
         conexionDB = new ConexionDB();
         conexion = ConexionDB.getConexion();
     }

     public void crearLibro(Libro libro){
         String sql ="INSERT INTO libro (titulo, idioma, id_formato ,id_editorial) VALUES (?,?,?,?)";
         try (PreparedStatement statement = conexion.prepareStatement(sql)){

             statement.setString(1,libro.getTitulo());
             statement.setString(2, libro.getIdioma());
             statement.setInt(3,libro.getId_formato());
             statement.setInt(4,libro.getId_editorial());
             statement.executeUpdate();
             conexion.close();

         }catch (SQLException e){
             System.out.println("Error al crear libro"+ e.getMessage());
         }

     }

}
