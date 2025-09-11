package edu.dosw.taller1dosw;

import java.util.List;

public interface RepositorioProducto {
    Producto guardar(Producto p);
    Producto buscarConId(int id);
    List<Producto> encontrarTodos();
}
