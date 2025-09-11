package edu.dosw.taller1dosw;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class ControlProducto {
    private final ServicioProducto servicioProducto;

    public ControlProducto(ServicioProducto servicioProducto) {
        this.servicioProducto = servicioProducto;
    }

    @PostMapping
    public ResponseEntity<Producto> añadir(@RequestBody SolicitudCrearProducto solicitud) {
        Producto p = servicioProducto.añadirProducto(
                solicitud.nombre, solicitud.categoria, solicitud.precio, solicitud.cantidad
        );
        return ResponseEntity.ok(p);
    }

    @PutMapping("/{id}/stock")
    public ResponseEntity<Producto> actualizarStock(@PathVariable int id,
                                                    @RequestBody SolicitudActualizarStock solicitud) {
        Producto p = servicioProducto.actualizarStock(id, solicitud.cantidad);
        return ResponseEntity.ok(p);
    }

    @GetMapping
    public ResponseEntity<List<Producto>> listar() {
        return ResponseEntity.ok(servicioProducto.listarTodo());
    }
}
