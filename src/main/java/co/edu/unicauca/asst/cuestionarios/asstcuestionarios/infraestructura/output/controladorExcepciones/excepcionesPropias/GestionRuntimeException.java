package co.edu.unicauca.asst.cuestionarios.asstcuestionarios.infraestructura.output.controladorExcepciones.excepcionesPropias;

import co.edu.unicauca.asst.cuestionarios.asstcuestionarios.infraestructura.output.controladorExcepciones.estructuraExcepciones.CodigoError;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public abstract class GestionRuntimeException extends RuntimeException {

    protected CodigoError codigoError;

    public abstract String formatException();

}
