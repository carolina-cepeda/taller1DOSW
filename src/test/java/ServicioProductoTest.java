

import edu.dosw.taller1dosw.ObservadorStock;
import edu.dosw.taller1dosw.Producto;
import edu.dosw.taller1dosw.RepositorioProductosEnMemoria;
import edu.dosw.taller1dosw.ServicioProducto;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ServicioProductoTest {

    static class ObservadorPrueba implements ObservadorStock {
        Producto ultimoNotificado = null;

        @Override
        public void cambiosEnStock(Producto producto) {
            ultimoNotificado = producto;
        }
    }

    @Test
    void añadirProductoDebeNotificarObservadores() {
        RepositorioProductosEnMemoria repo = new RepositorioProductosEnMemoria();
        ObservadorPrueba obs1 = new ObservadorPrueba();
        ObservadorPrueba obs2 = new ObservadorPrueba();
        List<ObservadorStock> observadores = new ArrayList<>();
        observadores.add(obs1);
        observadores.add(obs2);

        ServicioProducto servicio = new ServicioProducto(repo, observadores);

        Producto p = servicio.añadirProducto("Lapiz", "Papeleria", 0.5, 10);

        assertNotNull(p);
        assertEquals("Lapiz", p.getNombre());
        assertEquals(10, p.getCantidad());
        assertEquals(p, obs1.ultimoNotificado);
        assertEquals(p, obs2.ultimoNotificado);
    }

    @Test
    void actualizarStockDebeModificarCantidadYNotificar() {
        RepositorioProductosEnMemoria repo = new RepositorioProductosEnMemoria();
        ObservadorPrueba obs = new ObservadorPrueba();
        ServicioProducto servicio = new ServicioProducto(repo, List.of(obs));

        Producto p = servicio.añadirProducto("Cuaderno", "Papeleria", 2.5, 20);
        servicio.actualizarStock(p.getId(), 5);

        assertEquals(5, p.getCantidad());
        assertEquals(5, obs.ultimoNotificado.getCantidad());
    }

    @Test
    void actualizarStockProductoInexistenteDebeLanzarExcepcion() {
        RepositorioProductosEnMemoria repo = new RepositorioProductosEnMemoria();
        ServicioProducto servicio = new ServicioProducto(repo, List.of());

        assertThrows(IllegalArgumentException.class,
                () -> servicio.actualizarStock(999, 10));
    }

}
