package controller;

import dao.ProductoDAO;
import model.Producto;
import views.ProductoView;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductoController {
    private final ProductoDAO productoDAO;
    private final Scanner scanner;

    public ProductoController() {
        productoDAO = new ProductoDAO();
        scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {
        int opcion;
        do {
            System.out.println("\n--- Menú de Productos ---");
            System.out.println("1. Validar producto");
            System.out.println("2. Crear producto");
            System.out.println("3. Leer productos");
            System.out.println("4. Actualizar producto");
            System.out.println("5. Eliminar producto");
            System.out.println("6. consular nombres");
            System.out.println("7. consultar precios ");
            System.out.println("8. Cantidad de Clientes");
            System.out.println("9. filtro");
            System.out.println("0. Salir");
            System.out.print("Ingrese una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    validarProducto();
                    break;
                case 2:
                    crearProducto();
                    break;
                case 3:
                    leerProductos();
                    break;
                case 4:
                    actualizarProducto();
                    break;
                case 5:
                    eliminarProducto();
                    break;
                case 6:
                    ejecutarConsulta();
                    break;
                case 7:
                    columnaEntero();
                case 8:
                    cantidadProductos();
                case 9:
                    filtro();
                    break;
                case 0:
                    System.out.println("Saliendo del programa.");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
            }
        } while (opcion != 0);
    }

    private void crearProducto() {
        System.out.print("Ingrese el nombre del producto: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese el precio del producto: ");
        int precio = scanner.nextInt();
        System.out.print

                ("Ingrese ID de la categoria: ");
        int idCategoria = scanner.nextInt();
        Producto producto = new Producto(1, nombre, precio, idCategoria);
        productoDAO.crearProducto(producto);



    }

    private void leerProductos() {
        List<Producto> productos = productoDAO.leerProductos();
        ProductoView.mostrarProductos(productos);
    }

    private void actualizarProducto() {
        leerProductos();
        System.out.print("\nIngrese el ID del producto que desea actualizar: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer del scanner
        System.out.print("Ingrese el nuevo nombre del producto: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese el nuevo precio del producto: ");
        int precio = scanner.nextInt();
        System.out.print("Desea cambiar el id de la categoria-producto: ");
        int idCategoria = scanner.nextInt();


        Producto producto = new Producto(id, nombre, precio, idCategoria);
        productoDAO.actualizarProducto(producto);
    }

    private void eliminarProducto() {
        leerProductos();
        System.out.print("\nIngrese el ID del producto que desea eliminar: ");
        int id = scanner.nextInt();
        productoDAO.eliminarProducto(id);
        ProductoView.mostrarMensaje("Producto eliminado exitosamente.");
    }

    private void validarProducto() {
        System.out.println("ingrese nombre del producto");
        String nombre = scanner.nextLine();
        int respuesta = productoDAO.validarDatos(nombre);
        if (respuesta==1 ) {
            System.out.println("el producto ya xiste");
        }else {
            System.out.println("el producto no existe");
        }
    }

     private void ejecutarConsulta (){
        System.out.println("ingrese el nombre de un producto: ");
        String nombreValor = scanner.nextLine();
        productoDAO.ejecutarConsulta(nombreValor);
     }

     private void columnaEntero (){
        System.out.println("ingrese un ID");
        int nuevoId = scanner.nextInt();
        productoDAO.colunmaEntero(nuevoId);
     }

     private void  cantidadProductos (){
        System.out.println("PRODUCTOS EN ASCENDENTE..");
         productoDAO.cantidadProductos();
     }

     public void filtro(){
         System.out.println("ingrese un valor");
         String nombre = scanner.nextLine();
         List<Producto>resultado = productoDAO.filtro(nombre);
         ProductoView.mostrarProductos(resultado);
     }


}

