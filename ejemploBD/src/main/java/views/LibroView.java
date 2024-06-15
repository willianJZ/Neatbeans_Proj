package views;

import model.Libro;


import java.util.List;

public class LibroView {
    public static void mostrarLibros (List<Libro>libros){
        if (libros.isEmpty()) {
            System.out.println("No hay libros disponibles.");
        } else {
            System.out.println("\n--- Lista de Productos ---");

            for (Libro libro : libros) {
                System.out.println("ID: "+ libro.getId_libro() + ". titulo: " + libro.getTitulo() + " -  idioma: " + libro.getIdioma()+". formato: "+ libro.getId_formato()+". editorial: "+ libro.getId_editorial());
            }
        }
    }

    public static void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    }

