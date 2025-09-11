package edu.dosw.taller1dosw;

public class Producto {
    private final int id;
    private final String nombre;
    private final String categoria;
    private final double precio;
    private int cantidad;

    private static int contador = 1;

    public Producto(String nombre, String categoria, double precio, int cantidad) {
        this.id = contador++;
        this.nombre = nombre;
        this.categoria = categoria;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public String getCategoria() { return categoria; }
    public double getPrecio() { return precio; }
    public int getCantidad() { return cantidad; }
    public void setCantidad(int cantidad) { this.cantidad = cantidad; }
}
