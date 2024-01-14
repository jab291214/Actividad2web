package ms_operar.operar.entidad;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

import lombok.NoArgsConstructor;
import nonapi.io.github.classgraph.json.Id;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Compra {
    @Id
    private String id;
    private String idProducto;
    @NotNull(message = "El campo fecha no puede ser nulo")
    @NotEmpty(message = "El campo fecha no puede ser vacio")
    private String fecha;
    @NotNull(message = "El campo preciocompra no puede ser nulo")
    @NotEmpty(message = "El campo preciocompra no puede ser vacio")
    private String precioCompra;
}
