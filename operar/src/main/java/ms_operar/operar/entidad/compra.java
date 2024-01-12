package ms_operar.operar.entidad;

import lombok.AllArgsConstructor;
import lombok.Data;

import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class compra {
    private String id;
    private String idProducto;
    private String fecha;
    private String precioCompra;
}
