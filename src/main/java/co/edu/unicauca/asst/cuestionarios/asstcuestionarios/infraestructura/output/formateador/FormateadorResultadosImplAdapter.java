package co.edu.unicauca.asst.cuestionarios.asstcuestionarios.infraestructura.output.formateador;

import org.springframework.stereotype.Service;

import co.edu.unicauca.asst.cuestionarios.asstcuestionarios.aplicacion.output.FormateadorResultadosIntPort;
import co.edu.unicauca.asst.cuestionarios.asstcuestionarios.infraestructura.output.controladorExcepciones.excepcionesPropias.EntidadNoExisteException;
import co.edu.unicauca.asst.cuestionarios.asstcuestionarios.infraestructura.output.controladorExcepciones.excepcionesPropias.EntidadYaExisteException;
import co.edu.unicauca.asst.cuestionarios.asstcuestionarios.infraestructura.output.controladorExcepciones.excepcionesPropias.ReglaNegocioException;

@Service
public class FormateadorResultadosImplAdapter implements FormateadorResultadosIntPort {

    @Override
    public void retornarRespuestaErrorEntidadExistente(String mensaje) {
        throw new EntidadYaExisteException(mensaje);
    }

    @Override
    public void retornarRespuestaErrorReglaDeNegocio(String mensaje) {
        throw new ReglaNegocioException(mensaje);
    }

    @Override
    public void retornarRespuestaErrorEntidadNoExistente(String mensaje) { 
        throw new EntidadNoExisteException(mensaje);
    }

}
