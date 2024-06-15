package model;

public class Producto {
    private int id;
    private String nombre;
    private int precio;
    private int idCategoria;

    public Producto(String nombre, int precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public Producto(int id, String nombre, int precio, int idCategoria) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.idCategoria = idCategoria;


    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }
}