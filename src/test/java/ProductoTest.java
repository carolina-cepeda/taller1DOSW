
import edu.dosw.taller1dosw.Producto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductoTest {

    @Test
    void crearProductoDebeAsignarDatosCorrectos() {
        Producto p = new Producto("Lapiz", "Papeleria", 0.5, 10);

        assertNotNull(p.getId());
        assertEquals("Lapiz", p.getNombre());
        assertEquals("Papeleria", p.getCategoria());
        assertEquals(0.5, p.getPrecio());
        assertEquals(10, p.getCantidad());
    }

    @Test
    void setCantidadDebeActualizarCantidad() {
        Producto p = new Producto("Cuaderno", "Papeleria", 3.0, 20);

        p.setCantidad(5);

        assertEquals(5, p.getCantidad());
    }
}
