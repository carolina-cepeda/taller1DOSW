package edu.dosw.taller1dosw;

import org.springframework.stereotype.Component;

@Component
public class AgenteAdvertencia implements ObservadorStock {
    private final int limite = 5;

    @Override
    public void cambiosEnStock(Producto producto) {
        if (producto.getCantidad() < limite) {
            System.out.printf("AgenteAdvertencia -> ALERTA: %s con %d unidades (< %d)%n",
                    producto.getNombre(), producto.getCantidad(), limite);
        }
    }
}
