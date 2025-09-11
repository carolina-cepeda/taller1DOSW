
import edu.dosw.taller1dosw.Producto;
import edu.dosw.taller1dosw.RepositorioProductosEnMemoria;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RepositorioProductosEnMemoriaTest {

    @Test
    void guardarDebeAlmacenarYRetornarProducto() {
        RepositorioProductosEnMemoria repo = new RepositorioProductosEnMemoria();
        Producto p = new Producto("Borrador", "Papeleria", 0.8, 15);

        Producto guardado = repo.guardar(p);

        assertEquals(p, guardado);
        assertEquals(p, repo.buscarConId(p.getId()));
    }

    @Test
    void buscarConIdInexistenteDebeRetornarNull() {
        RepositorioProductosEnMemoria repo = new RepositorioProductosEnMemoria();

        Producto encontrado = repo.buscarConId(999);

        assertNull(encontrado);
    }

    @Test
    void encontrarTodosDebeRetornarListaConProductos() {
        RepositorioProductosEnMemoria repo = new RepositorioProductosEnMemoria();

        Producto p1 = new Producto("Lapiz", "Papeleria", 0.5, 10);
        Producto p2 = new Producto("Cuaderno", "Papeleria", 3.0, 20);
        repo.guardar(p1);
        repo.guardar(p2);

        List<Producto> productos = repo.encontrarTodos();

        assertTrue(productos.contains(p1));
        assertTrue(productos.contains(p2));
        assertEquals(2, productos.size());
    }
}
