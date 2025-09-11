

import edu.dosw.taller1dosw.AgenteLog;
import edu.dosw.taller1dosw.Producto;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

class AgenteLogTest {

    @Test
    void debeImprimirLogCuandoSeCambiaElStock() {
        AgenteLog agente = new AgenteLog();
        Producto p = new Producto("Borrador", "Papeleria", 0.8, 7);

        ByteArrayOutputStream salida = new ByteArrayOutputStream();
        PrintStream original = System.out;
        System.setOut(new PrintStream(salida));

        agente.cambiosEnStock(p);

        System.setOut(original);
        String texto = salida.toString();
        assertTrue(texto.contains("Producto: Borrador"));
    }
}
