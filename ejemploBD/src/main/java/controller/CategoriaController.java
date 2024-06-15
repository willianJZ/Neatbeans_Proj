package controller;


import dao.CategoriaDAO;
import model.Categoria;
import views.CategoriaView;
import java.util.List;
import java.util.Scanner;

public class CategoriaController {
    private  final CategoriaDAO categoriaDAO;
    private final Scanner scanner;

    public CategoriaController() {
        categoriaDAO = new CategoriaDAO();

        scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {
        int opcion;
        do {
            System.out.println("\n--- Menú de Categorías ---");
            System.out.println("1. Crear categoría");
            System.out.println("2. Leer categorías");
            System.out.println("3. Actualizar categoría");
            System.out.println("4. Eliminar categoría");
            System.out.println("0. Salir");
            System.out.print("Ingrese una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer del scanner

            switch (opcion) {
                case 1:
                    crearCategoria();
                    break;
                case 2:
                    leerCategorias();
                    break;
                case 3:
                    actualizarCategoria();
                    break;
                case 4:
                    eliminarCategoria();
                    break;
                case 0:
                    System.out.println("Saliendo del programa.");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
            }
        } while (opcion != 0);
    }

    private void crearCategoria() {
        System.out.print("Ingrese el nombre de la categoría: ");
        String nombre = scanner.nextLine();
        Categoria categoria = new Categoria(0, nombre);
        categoriaDAO.CrearCategoria(categoria);
        CategoriaView.mostrarMensaje("Categoría creada exitosamente.");
    }

    private void leerCategorias() {
        List<Categoria> categorias = categoriaDAO.leerCategorias();
        CategoriaView.mostrarCategorias(categorias);
    }

    private void actualizarCategoria() {
        leerCategorias();
        System.out.print("\nIngrese el ID de la categoría que desea actualizar: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer del scanner
        System.out.print("Ingrese el nuevo nombre de la categoría: ");
        String nuevoNombre = scanner.nextLine();
        Categoria categoria = new Categoria(id, nuevoNombre);
        categoriaDAO.actualizarCategoria(categoria);
        CategoriaView.mostrarMensaje("Categoría actualizada exitosamente.");
    }

    private void eliminarCategoria() {
        leerCategorias();
        System.out.print("\nIngrese el ID de la categoría que desea eliminar: ");
        int id = scanner.nextInt();
        categoriaDAO.eliminarCategoria(id);
        CategoriaView.mostrarMensaje("Categoría eliminada exitosamente.");
    }
}
