package co.edu.unicauca.asst.cuestionarios.asstcuestionarios.aplicacion.input;

import java.util.List;

import co.edu.unicauca.asst.cuestionarios.asstcuestionarios.dominio.modelos.Respuesta;

public interface GestionarRespuestasCUIntPort {

    public List<Respuesta> crearRespuestas(List<Respuesta> respuestas);

    public List<Respuesta> listarRespuestas();

    public List<Respuesta> listarRespuestasPorDocente(String numeroIdentificacion);

    public List<Respuesta> listarRespuestasPorDocenteConId(Integer idPersona);
}
