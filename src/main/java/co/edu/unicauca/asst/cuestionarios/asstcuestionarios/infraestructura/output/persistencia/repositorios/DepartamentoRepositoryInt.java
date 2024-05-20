package co.edu.unicauca.asst.cuestionarios.asstcuestionarios.infraestructura.output.persistencia.repositorios;

import org.springframework.data.repository.CrudRepository;

import co.edu.unicauca.asst.cuestionarios.asstcuestionarios.infraestructura.output.persistencia.entidades.DepartamentoEntity;

public interface DepartamentoRepositoryInt extends CrudRepository<DepartamentoEntity, Integer> {

}
