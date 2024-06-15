
package dao;

import config.ConexionDB;

import model.Producto;
import views.ProductoView;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class ProductoDAO {
    private Connection conexion;
    private ConexionDB conexionDB;

    public ProductoDAO() {
        conexionDB = new ConexionDB();
        conexion = ConexionDB.getConexion();


    }


    public void crearProducto(Producto producto) {
        String sql = "INSERT INTO productos (nombre, precio, idCategoria) VALUES (?, ?, ?)";
        try (PreparedStatement preparedStatement = conexion.prepareStatement(sql)) {
            preparedStatement.setString(1, producto.getNombre());
            preparedStatement.setInt(2, producto.getPrecio());
            preparedStatement.setInt(3, producto.getIdCategoria());
            preparedStatement.executeUpdate();

            ProductoView.mostrarMensaje("Producto creado exitosamente.");
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        conexionDB.closeConexion(conexion);
    }

    public List<Producto> leerProductos() {
        List<Producto> productos = new ArrayList<>();
        String sql = "SELECT * FROM productos";
        try (Statement statement = conexion.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nombre = resultSet.getString("nombre");
                int precio = resultSet.getInt("precio");
                int idCategoria = resultSet.getInt("idCategoria");
                Producto producto = new Producto(id, nombre, precio, idCategoria);
                productos.add(producto);

            }
        } catch (SQLException e) {
            System.out.println("Error al consultar los datos: " + e.getMessage());
        }
        return productos;
    }

    public void actualizarProducto(Producto producto) {
        String sql = "UPDATE productos SET nombre = ?, precio = ?, idCategoria = ? WHERE id = ?";
        try (PreparedStatement preparedStatement = conexion.prepareStatement(sql)) {
            preparedStatement.setString(1, producto.getNombre());
            preparedStatement.setInt(2, producto.getPrecio());
            preparedStatement.setInt(3, producto.getIdCategoria());
            preparedStatement.setInt(4, producto.getId());
            preparedStatement.executeUpdate();
            System.out.println(" !Se ha actualizado¡ ");

        } catch (SQLException e) {
            System.out.println("Error al actualizar los datos: " + e.getMessage());
        }
        conexionDB.closeConexion(conexion);
    }

    public void eliminarProducto(int id) {
        String sql = "DELETE FROM productos WHERE id = ?";
        try (PreparedStatement preparedStatement = conexion.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al eliminar los datos: " + e.getMessage());
        }
    }

    public int validarDatos(String nombre) {
        int respuesta = 0;
        String sql = "select count(*) as nombre from productos  where nombre = ?";
        try (PreparedStatement statement = conexion.prepareStatement(sql)) {
            statement.setString(1, nombre);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                respuesta = resultSet.getInt("nombre");
                System.out.println(respuesta);
            }
        } catch (SQLException e) {
            System.out.println("error al validar" + e.getMessage());
        }
        return respuesta;


    }

    public void ejecutarConsulta(String valor) {
        String sql = "SELECT * FROM productos WHERE nombre = ?";
        try (PreparedStatement preparedStatement = conexion.prepareStatement(sql)) {
            preparedStatement.setString(1, valor);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nombreProducto = resultSet.getString("nombre");
                int precio = resultSet.getInt("precio");
                int idCategoria = resultSet.getInt("idCategoria");
                System.out.println(" ID:" + id + " Nombre:" + nombreProducto + " precio:" + precio + " idCategoria:" + idCategoria);
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }


    public void colunmaEntero(int nuevoId) {
        String sql = " SELECT * FROM productos WHERE id = ?";
        try (PreparedStatement preparedStatement = conexion.prepareStatement(sql)) {
            preparedStatement.setInt(1, nuevoId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nombre = resultSet.getString("nombre");
                int precio = resultSet.getInt("precio");
                int idCategoria = resultSet.getInt("idCategoria");
                System.out.println("ID: " + id + " Nombre: " + nombre + "Precio: " + precio + "idCategoria: " + idCategoria);
            }
        } catch (SQLException e) {
            System.out.println("error: " + e.getMessage());
        }
    }

    public void cantidadProductos() {
        String sql = "SELECT * FROM productos ORDER BY nombre ASC;";
        try (PreparedStatement preparedStatement = conexion.prepareStatement(sql)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nombre = resultSet.getString("nombre");
                int precio = resultSet.getInt("precio");
                int idCategoria = resultSet.getInt("idCategoria");
                System.out.println(" ID:" + id + " Nombre:" + nombre + " Precio:" + precio + " Categoria:" + idCategoria);
            }
        } catch (SQLException e) {
            System.out.println("Error:  " + e.getMessage());
        }
    }

    public List<Producto> filtro(String valor) {
        List<Producto> resultado = new ArrayList<>();
        String sql = "SELECT p.nombre, p.precio FROM productos p WHERE p.nombre LIKE ?";
        try (PreparedStatement statement = conexion.prepareStatement(sql)) {
            statement.setString(1, "%" + valor + "%");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String nombre = resultSet.getString("nombre");
                int precio = resultSet.getInt("precio");
                Producto producto = new Producto(nombre, precio);
                resultado.add(producto);
            }

        } catch (SQLException e) {
            System.out.println("ERROR " + e.getMessage());
        }
        return resultado;
    }


}
