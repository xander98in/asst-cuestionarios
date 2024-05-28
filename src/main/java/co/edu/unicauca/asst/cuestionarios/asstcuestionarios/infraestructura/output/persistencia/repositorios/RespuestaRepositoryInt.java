package co.edu.unicauca.asst.cuestionarios.asstcuestionarios.infraestructura.output.persistencia.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import co.edu.unicauca.asst.cuestionarios.asstcuestionarios.infraestructura.output.persistencia.entidades.RespuestaEntity;

public interface RespuestaRepositoryInt extends CrudRepository<RespuestaEntity, Integer> {

    @Query("SELECT COUNT(r) > 0 FROM RespuestaEntity r WHERE r.objCuestionario.idCuestionario = :idCuestionario")
    boolean existeCuestionarioRespondido(@Param("idCuestionario") Integer idCuestionario);

    boolean existsByObjCuestionarioIdCuestionario(Integer idCuestionario);

    @Query("SELECT r FROM RespuestaEntity r JOIN r.objDocente d WHERE d.numeroIdentificacion = :numeroIdentificacion")
    List<RespuestaEntity> findByNumeroIdentificacion(@Param("numeroIdentificacion") String numeroIdentificacion);

    @Query("SELECT r FROM RespuestaEntity r WHERE r.objDocente.idPersona = :idPersona")
    List<RespuestaEntity> findByIdPersona(@Param("idPersona") Integer idPersona);
}
