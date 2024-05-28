package co.edu.unicauca.asst.cuestionarios.asstcuestionarios.infraestructura.output.persistencia.repositorios;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import co.edu.unicauca.asst.cuestionarios.asstcuestionarios.infraestructura.output.persistencia.entidades.RespuestaEntity;

public interface RespuestaRepositoryInt extends CrudRepository<RespuestaEntity, Integer> {

    @Query("SELECT COUNT(r) > 0 FROM RespuestaEntity r WHERE r.objCuestionario.idCuestionario = :idCuestionario")
    boolean existeCuestionarioRespondido(@Param("idCuestionario") Integer idCuestionario);

    boolean existsByObjCuestionarioIdCuestionario(Integer idCuestionario);

}
