package dao;

import config.ConexionDB;
import model.Categoria;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoriaDAO {
    private final Connection conexion;
    private final ConexionDB conexionDB;


    public CategoriaDAO() {
        conexionDB = new ConexionDB();
        conexion = ConexionDB.getConexion();
    }

    public void CrearCategoria(Categoria categoria) {
        String sql = "INSERT INTO categoria (nombre) VALUES (?)";
        try (PreparedStatement statement = conexion.prepareStatement(sql)) {
            statement.setString(1, categoria.getNombre());
            statement.executeUpdate();
            conexion.close();
        } catch (SQLException e) {
            System.out.println("Error al guardar los datos" + e.getMessage());
        }
    }

    public List<Categoria> leerCategorias() {
        List<Categoria> categorias = new ArrayList<>();
        String sql = "SELECT * FROM categoria";
        try (Statement statement = conexion.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nombre = resultSet.getString("nombre");
                Categoria categoria = new Categoria(id, nombre);
                categorias.add(categoria);
                conexion.close();
            }
        } catch (SQLException e) {
            System.out.println("Error al consultar los datos: " + e.getMessage());
        }
        return categorias;
    }

    public void actualizarCategoria(Categoria categoria) {
        String sql = "UPDATE categoria SET nombre = ? WHERE id = ?";
        try (PreparedStatement statement = conexion.prepareStatement(sql)) {
            statement.setString(1, categoria.getNombre());
            statement.setInt(2, categoria.getId());
            statement.executeUpdate();
            conexion.close();
        } catch (SQLException e) {
            System.out.println("Error al actualizar los datos" + e.getMessage());
        }
    }

    public void eliminarCategoria( int id) {
        String sql = "DELETE FROM categoria  Where id = ?";
        try (PreparedStatement statement = conexion.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
            conexion.close();
        } catch (SQLException e) {
            System.out.println("Error al eliminar " + e.getMessage());
        }

    }
}
