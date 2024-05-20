package co.edu.unicauca.asst.cuestionarios.asstcuestionarios.infraestructura.output.persistencia.repositorios;

import org.springframework.data.repository.CrudRepository;

import co.edu.unicauca.asst.cuestionarios.asstcuestionarios.infraestructura.output.persistencia.entidades.PreguntaEntity;

public interface PreguntaRepositoryInt extends CrudRepository<PreguntaEntity, Integer> {

}
