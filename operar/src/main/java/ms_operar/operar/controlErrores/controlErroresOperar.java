package ms_operar.operar.controlErrores;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;

import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import ms_operar.operar.entidad.ErrorResponse;
import ms_operar.operar.entidad.Error;
@RestControllerAdvice
public class controlErroresOperar {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> controlErrorEntidadCompra(MethodArgumentNotValidException ex) {
        List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();
        ErrorResponse errorResponse = new ErrorResponse();
        List<Error> errores = new ArrayList<>();
        fieldErrors.forEach((error) -> {
            Error err = new Error();
            err.setTipo("campo: " + ((FieldError) error).getField());
            err.setMensaje(error.getDefaultMessage());
            errores.add(err);
        });
        errorResponse.setMensaje("Error de tipo de dato");
        errorResponse.setStatus(400);
        errorResponse.setTimestamp(new Date());
        errorResponse.setError(errores);
        return ResponseEntity.badRequest().body(errorResponse);
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String metodoNoEncontrado() {
        return "Metodo no encontrado";
    }

    @ExceptionHandler(NoResourceFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String endpointNoEncontrado() {
        return "Endpoint no encontrado";
    }

}
