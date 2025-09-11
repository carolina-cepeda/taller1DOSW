
import edu.dosw.taller1dosw.SolicitudActualizarStock;
import edu.dosw.taller1dosw.SolicitudCrearProducto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolicitudesDtoTest {

    @Test
    void solicitudCrearProductoDebeAlmacenarDatos() {
        SolicitudCrearProducto solicitud = new SolicitudCrearProducto();
        solicitud.nombre = "Lapiz";
        solicitud.categoria = "Papeleria";
        solicitud.precio = 1.5;
        solicitud.cantidad = 10;

        assertEquals("Lapiz", solicitud.nombre);
        assertEquals("Papeleria", solicitud.categoria);
        assertEquals(1.5, solicitud.precio);
        assertEquals(10, solicitud.cantidad);
    }

    @Test
    void solicitudActualizarStockDebeAlmacenarCantidad() {
        SolicitudActualizarStock solicitud = new SolicitudActualizarStock();
        solicitud.cantidad = 7;

        assertEquals(7, solicitud.cantidad);
    }
}
