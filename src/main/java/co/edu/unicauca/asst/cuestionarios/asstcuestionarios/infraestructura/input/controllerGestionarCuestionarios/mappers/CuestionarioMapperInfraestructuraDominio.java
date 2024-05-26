package co.edu.unicauca.asst.cuestionarios.asstcuestionarios.infraestructura.input.controllerGestionarCuestionarios.mappers;

import java.util.List;

import org.mapstruct.Mapper;

import co.edu.unicauca.asst.cuestionarios.asstcuestionarios.dominio.modelos.Cuestionario;
import co.edu.unicauca.asst.cuestionarios.asstcuestionarios.infraestructura.input.controllerGestionarCuestionarios.DTOPeticion.CuestionarioDTOPeticion;
import co.edu.unicauca.asst.cuestionarios.asstcuestionarios.infraestructura.input.controllerGestionarCuestionarios.DTORespuesta.CuestionarioDTORespuesta;

@Mapper(componentModel = "spring")
public interface CuestionarioMapperInfraestructuraDominio {

    Cuestionario mappearDePeticionACuestionario(CuestionarioDTOPeticion peticion);

    CuestionarioDTORespuesta mappearDeCuestionarioARespuesta(Cuestionario objCuestionario);

    List<CuestionarioDTORespuesta> mappearDeCuestionariosARespuesta(List<Cuestionario> Cuestionarios);

}
