package co.edu.unicauca.asst.cuestionarios.asstcuestionarios.infraestructura.output.persistencia.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import co.edu.unicauca.asst.cuestionarios.asstcuestionarios.infraestructura.output.persistencia.entidades.CuestionarioEntity;

public interface CuestionarioRepositoryInt extends CrudRepository<CuestionarioEntity, Integer> {

    @Query("SELECT count(c) > 0 FROM CuestionarioEntity c WHERE c.titulo = :titulo")
    Boolean existeCuestionarioConTitulo(String titulo);

    // obteniene los cuestionarios por un patrón del título, ignorando mayúsculas y
    // minúsculas y ordenándolas por el id de mayor a menor
    List<CuestionarioEntity> findAllByTituloContainingIgnoreCaseOrderByIdCuestionarioDesc(String titulo);
}
