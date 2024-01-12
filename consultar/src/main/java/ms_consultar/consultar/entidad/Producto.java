package ms_consultar.consultar.entidad;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "productos")
@Entity
public class Producto {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    @NotNull(message = "El campo nombre no puede ser nulo")
    @NotEmpty(message = "El campo nombre no puede ser vacio")
    private String nombre;
    @NotNull(message = "El campo descripcion no puede ser nulo")
    @NotEmpty(message = "El campo descripcion no puede ser vacio")
    private String descripcion;
    @NotNull(message = "El campo precio no puede ser nulo")
    private Integer precio;

}
