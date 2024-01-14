package ms_operar.operar.entidad;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CompraDTO {
    public String idcompra;
    public String nombre;
    public String descripcion;
    public Integer precio;
    public String idProducto;
    public String fecha;
    public String precioCompra;
}
