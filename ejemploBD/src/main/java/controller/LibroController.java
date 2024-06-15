package controller;

import dao.LibroDAO;
import model.Libro;
import views.LibroView;


import java.util.Scanner;

public class LibroController {
    private final LibroDAO libroDAO;
    private final Scanner scanner;

    public LibroController() {
        libroDAO = new LibroDAO();
        scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {
        int opcion;
        do {
            System.out.println("\n--- Menú de LIBROS ---");
            System.out.println("1. Crear libro");
            System.out.println("2. Mostrar libros");
            System.out.println("3. Actualizar libros");
            System.out.println("4. Eliminar libro");
            System.out.println("0. Salir");
            System.out.print("Ingrese una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    crearLibro();
                    break;
                case 0:
                    System.out.println("Saliendo del programa.");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
            }
        } while (opcion != 0);
    }


    private void crearLibro() {
        System.out.println("Ingrese el titulo del  libro");
        String titulo = scanner.next();
        System.out.println("Ingrese el idioma en que desea el libro");
        String idioma = scanner.next();
        System.out.println("fortamo que desea: 1.PDF 2.FISICO 3.Impreso");
        int formato = scanner.nextInt();
        System.out.println("Elija una editorial del 1 al 3");
        int editorial = scanner.nextInt();

        Libro libro = new Libro(0, titulo, idioma, formato, editorial);
        libroDAO.crearLibro(libro);
        LibroView.mostrarMensaje("¡Creado exitosamente!");

    }
}
