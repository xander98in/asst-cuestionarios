package co.edu.unicauca.asst.cuestionarios.asstcuestionarios.infraestructura.output.formateador;

import org.springframework.stereotype.Service;

import co.edu.unicauca.asst.cuestionarios.asstcuestionarios.aplicacion.output.FormateadorResultadosIntPort;
import co.edu.unicauca.asst.cuestionarios.asstcuestionarios.infraestructura.output.controladorExcepciones.excepcionesPropias.EntidadYaExisteException;

@Service
public class FormateadorResultadosImplAdapter implements FormateadorResultadosIntPort {

    @Override
    public void retornarRespuestaErrorEntidadExistente(String mensaje) {
        EntidadYaExisteException objException = new EntidadYaExisteException(mensaje);
        throw objException;
    }

    @Override
    public void retornarRespuestaErrorReglaDeNegocio(String mensaje) {
        throw new UnsupportedOperationException("Unimplemented method 'retornarRespuestaErrorReglaDeNegocio'");
    }

}
