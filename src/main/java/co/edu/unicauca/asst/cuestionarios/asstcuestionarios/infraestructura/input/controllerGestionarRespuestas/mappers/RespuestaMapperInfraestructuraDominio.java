package co.edu.unicauca.asst.cuestionarios.asstcuestionarios.infraestructura.input.controllerGestionarRespuestas.mappers;

import java.util.List;

import org.mapstruct.Mapper;

import co.edu.unicauca.asst.cuestionarios.asstcuestionarios.dominio.modelos.Respuesta;
import co.edu.unicauca.asst.cuestionarios.asstcuestionarios.infraestructura.input.controllerGestionarRespuestas.DTOPeticion.RespuestaDTOPeticion;
import co.edu.unicauca.asst.cuestionarios.asstcuestionarios.infraestructura.input.controllerGestionarRespuestas.DTORespuesta.RespuestaDTORespuesta;

@Mapper(componentModel = "spring")
public interface RespuestaMapperInfraestructuraDominio {

    Respuesta mappearDePeticionARespuesta(RespuestaDTOPeticion peticion);

    RespuestaDTORespuesta mappearDeRespuestaARespuesta(Respuesta objRespuesta);

    List<Respuesta> mappearDePeticionesARespuestas(List<RespuestaDTOPeticion> peticiones);

    List<RespuestaDTORespuesta> mappearDeRespuestasARespuesta(List<Respuesta> respuestas);

}
