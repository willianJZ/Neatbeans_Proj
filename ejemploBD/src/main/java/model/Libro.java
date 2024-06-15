package model;

public class Libro {

    private int  id_libro;
    private  String titulo;
    private String idioma;
    private  int id_formato;
    private int id_editorial;

    public Libro(int id_libro, String titulo, String idioma, int id_formato, int id_editorial) {
        this.id_libro = id_libro;
        this.titulo = titulo;
        this.idioma = idioma;
        this.id_formato = id_formato;
        this.id_editorial = id_editorial;
    }

    public int getId_libro() {
        return id_libro;
    }

    public void setId_libro(int id_libro) {
        this.id_libro = id_libro;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public int getId_formato() {
        return id_formato;
    }

    public void setId_formato(int id_formato) {
        this.id_formato = id_formato;
    }

    public int getId_editorial() {
        return id_editorial;
    }

    public void setId_editorial(int id_editorial) {
        this.id_editorial = id_editorial;
    }
}
