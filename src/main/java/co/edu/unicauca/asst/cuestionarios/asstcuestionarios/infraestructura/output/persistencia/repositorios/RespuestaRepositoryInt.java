package co.edu.unicauca.asst.cuestionarios.asstcuestionarios.infraestructura.output.persistencia.repositorios;

import org.springframework.data.repository.CrudRepository;

import co.edu.unicauca.asst.cuestionarios.asstcuestionarios.infraestructura.output.persistencia.entidades.RespuestaEntity;

public interface RespuestaRepositoryInt extends CrudRepository<RespuestaEntity, Integer> {

}
