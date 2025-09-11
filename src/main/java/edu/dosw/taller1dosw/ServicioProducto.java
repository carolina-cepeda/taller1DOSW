package edu.dosw.taller1dosw;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioProducto {
    private final RepositorioProducto repositorio;
    private final List<ObservadorStock> observadores;

    public ServicioProducto(RepositorioProducto repositorio, List<ObservadorStock> observadores) {
        this.repositorio = repositorio;
        this.observadores = observadores;
    }

    public Producto añadirProducto(String nombre, String categoria, double precio, int cantidad) {
        Producto p = new Producto(nombre, categoria, precio, cantidad);
        repositorio.guardar(p);
        notificarObservadores(p);
        return p;
    }

    public Producto actualizarStock(int id, int nuevaCantidad) {
        Producto p = repositorio.buscarConId(id);
        if (p == null) {
            throw new IllegalArgumentException("Producto no encontrado: " + id);
        }
        p.setCantidad(nuevaCantidad);
        repositorio.guardar(p);
        notificarObservadores(p);
        return p;
    }

    public List<Producto> listarTodo() {
        return repositorio.encontrarTodos();
    }

    private void notificarObservadores(Producto producto) {
        for (ObservadorStock o : observadores) {
            o.cambiosEnStock(producto);
        }
    }
}
