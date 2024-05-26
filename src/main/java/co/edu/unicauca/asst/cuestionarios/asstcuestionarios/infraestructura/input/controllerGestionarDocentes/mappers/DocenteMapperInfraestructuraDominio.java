package co.edu.unicauca.asst.cuestionarios.asstcuestionarios.infraestructura.input.controllerGestionarDocentes.mappers;

import java.util.List;

import org.mapstruct.Mapper;

import co.edu.unicauca.asst.cuestionarios.asstcuestionarios.dominio.modelos.Docente;
import co.edu.unicauca.asst.cuestionarios.asstcuestionarios.infraestructura.input.controllerGestionarDocentes.DTOPeticion.DocenteDTOPeticion;
import co.edu.unicauca.asst.cuestionarios.asstcuestionarios.infraestructura.input.controllerGestionarDocentes.DTORespuesta.DocenteDTORespuesta;

@Mapper(componentModel = "spring")
public interface DocenteMapperInfraestructuraDominio {

    Docente mappearDePeticionADocente(DocenteDTOPeticion docente);

    DocenteDTORespuesta mappearDeDocenteARespuesta(Docente objDocente);

    List<DocenteDTORespuesta> mappearDeDocentesARespuesta(List<Docente> docentes);

}
