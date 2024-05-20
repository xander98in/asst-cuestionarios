package co.edu.unicauca.asst.cuestionarios.asstcuestionarios.infraestructura.output.controladorExcepciones;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import co.edu.unicauca.asst.cuestionarios.asstcuestionarios.infraestructura.output.controladorExcepciones.estructuraExcepciones.CodigoError;
import co.edu.unicauca.asst.cuestionarios.asstcuestionarios.infraestructura.output.controladorExcepciones.estructuraExcepciones.Error;
import co.edu.unicauca.asst.cuestionarios.asstcuestionarios.infraestructura.output.controladorExcepciones.estructuraExcepciones.ErrorUtils;
import co.edu.unicauca.asst.cuestionarios.asstcuestionarios.infraestructura.output.controladorExcepciones.excepcionesPropias.EntidadYaExisteException;
import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class RestApiExceptionHandler {

    
    @ExceptionHandler(EntidadYaExisteException.class)
    public ResponseEntity<Error> handleGenericException(final HttpServletRequest req,
        final EntidadYaExisteException ex) {

        final Error error = ErrorUtils
            .crearError(CodigoError.ENTIDAD_YA_EXISTE.getCodigo(),
                String.format("%s, %s", CodigoError.ENTIDAD_YA_EXISTE.getLlaveMensaje(), ex.getMessage()), 
                HttpStatus.NOT_ACCEPTABLE.value())
            .setUrl(req.getRequestURL().toString()).setMetodo(req.getMethod());

        return new ResponseEntity<Error>(error, HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        System.out.println("Retornando respuesta con los errores identificados");
        Map<String, String> errores = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
           String campo = ((FieldError) error).getField();
           String mensajeDeError = error.getDefaultMessage();
           errores.put(campo, mensajeDeError); 
        });

        return new ResponseEntity<Map<String, String>>(errores, HttpStatus.BAD_REQUEST);
    }

}
