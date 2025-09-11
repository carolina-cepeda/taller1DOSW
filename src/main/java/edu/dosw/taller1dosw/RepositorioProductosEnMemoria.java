package edu.dosw.taller1dosw;

import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class RepositorioProductosEnMemoria implements RepositorioProducto {
    private final Map<Integer, Producto> almacenado = new HashMap<>();

    @Override
    public Producto guardar(Producto p) {
        almacenado.put(p.getId(), p);
        return p;
    }

    @Override
    public Producto buscarConId(int id) {
        return almacenado.get(id);
    }

    @Override
    public List<Producto> encontrarTodos() {
        return new ArrayList<>(almacenado.values());
    }
}
