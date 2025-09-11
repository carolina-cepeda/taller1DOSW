
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.dosw.taller1dosw.Producto;
import edu.dosw.taller1dosw.SolicitudActualizarStock;
import edu.dosw.taller1dosw.SolicitudCrearProducto;
import edu.dosw.taller1dosw.Taller1DoswApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(classes = Taller1DoswApplication.class)
@AutoConfigureMockMvc
class ControlProductoTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper mapper;

    @Test
    void añadirDebeCrearProducto() throws Exception {
        SolicitudCrearProducto solicitud = new SolicitudCrearProducto();
        solicitud.nombre = "Cuaderno";
        solicitud.categoria = "Papeleria";
        solicitud.precio = 3.5;
        solicitud.cantidad = 12;

        mockMvc.perform(post("/api/productos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(solicitud)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nombre", is("Cuaderno")))
                .andExpect(jsonPath("$.cantidad", is(12)));
    }

    @Test
    void actualizarStockDebeCambiarCantidad() throws Exception {

        SolicitudCrearProducto solicitud = new SolicitudCrearProducto();
        solicitud.nombre = "Borrador";
        solicitud.categoria = "Papeleria";
        solicitud.precio = 0.8;
        solicitud.cantidad = 5;

        String respuesta = mockMvc.perform(post("/api/productos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(solicitud)))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();

        Producto creado = mapper.readValue(respuesta, Producto.class);


        SolicitudActualizarStock actualizar = new SolicitudActualizarStock();
        actualizar.cantidad = 20;

        mockMvc.perform(put("/api/productos/" + creado.getId() + "/stock")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(actualizar)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.cantidad", is(20)));
    }

    @Test
    void listarDebeRetornarListaDeProductos() throws Exception {
        mockMvc.perform(get("/api/productos"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }
}
