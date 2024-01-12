package ms_consultar.consultar.entidad;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponse {
    private int status;
    private String mensaje;
    private Date timestamp;
    List<Error> errors;
    ErrorResponse (String mensaje){
        this.mensaje =mensaje;
    }
    public void setError(List<Error> errores){
        errors = errores;
    }

}
