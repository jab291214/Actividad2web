package ms_consultar.consultar.entidad;

import lombok.AllArgsConstructor;
import lombok.Data;

import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor

public class Error {
    private String tipo;
    private String mensaje;
}
