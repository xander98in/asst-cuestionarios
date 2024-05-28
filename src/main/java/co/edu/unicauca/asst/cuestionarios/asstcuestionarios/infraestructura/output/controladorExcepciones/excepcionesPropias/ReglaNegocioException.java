package co.edu.unicauca.asst.cuestionarios.asstcuestionarios.infraestructura.output.controladorExcepciones.excepcionesPropias;

import co.edu.unicauca.asst.cuestionarios.asstcuestionarios.infraestructura.output.controladorExcepciones.estructuraExcepciones.CodigoError;

public class ReglaNegocioException extends GestionRuntimeException {

    private static final String FORMATO_EXCEPCION = "%s - Violación a regla de negocio: %s";

    private final String reglaNegocio;

    public ReglaNegocioException(final String reglaNegocio) {
        super(CodigoError.VIOLACION_REGLA_DE_NEGOCIO);
        this.reglaNegocio = reglaNegocio;
    }

    @Override
    public String formatException() {
        return String.format(FORMATO_EXCEPCION, codigoError.getCodigo(), reglaNegocio);
    }
}
