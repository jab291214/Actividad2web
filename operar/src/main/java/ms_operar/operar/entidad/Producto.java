package ms_operar.operar.entidad;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/*import jakarta.persistence.Entity;
import jakarta.persistence.Table;
@Table(name = "productos")
@Entity*/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Producto {
    private String id;
    private String nombre;
    private String descripcion;
    private Integer precio;


}
