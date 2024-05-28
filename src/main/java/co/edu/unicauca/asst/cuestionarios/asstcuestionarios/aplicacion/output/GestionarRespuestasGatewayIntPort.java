package co.edu.unicauca.asst.cuestionarios.asstcuestionarios.aplicacion.output;

import java.util.List;

import co.edu.unicauca.asst.cuestionarios.asstcuestionarios.dominio.modelos.Respuesta;

public interface GestionarRespuestasGatewayIntPort {

    public List<Respuesta> guardarRespuestas(List<Respuesta> respuestas);

    public List<Respuesta> listarRespuestas();

    public List<Respuesta> listarRespuestasPorDocente(String numeroIdentificacion);

    public List<Respuesta> listarRespuestasPorDocenteConId(Integer idPersona);

    public Boolean sePuedeResponderCuestionario(List<Respuesta> respuestas);

}
