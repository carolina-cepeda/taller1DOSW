
import edu.dosw.taller1dosw.AgenteAdvertencia;
import edu.dosw.taller1dosw.Producto;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

class AgenteAdvertenciaTest {

    @Test
    void debeImprimirAlertaCuandoStockEsBajo() {
        AgenteAdvertencia agente = new AgenteAdvertencia();
        Producto p = new Producto("Goma", "Papeleria", 1.0, 3);

        ByteArrayOutputStream salida = new ByteArrayOutputStream();
        PrintStream original = System.out;
        System.setOut(new PrintStream(salida));

        agente.cambiosEnStock(p);

        System.setOut(original);
        String texto = salida.toString();
        assertTrue(texto.contains("ALERTA"));
    }
}
