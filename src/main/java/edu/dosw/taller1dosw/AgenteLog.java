package edu.dosw.taller1dosw;

import org.springframework.stereotype.Component;

@Component
public class AgenteLog implements ObservadorStock {
    @Override
    public void cambiosEnStock(Producto producto) {
        System.out.printf("AgenteLog -> Producto: %s | Cantidad: %d%n",
                producto.getNombre(), producto.getCantidad());
    }
}
