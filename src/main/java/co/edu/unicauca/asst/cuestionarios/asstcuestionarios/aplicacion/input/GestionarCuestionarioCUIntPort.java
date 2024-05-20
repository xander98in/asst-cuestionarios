package co.edu.unicauca.asst.cuestionarios.asstcuestionarios.aplicacion.input;

import java.util.List;

import co.edu.unicauca.asst.cuestionarios.asstcuestionarios.dominio.modelos.Cuestionario;

public interface GestionarCuestionarioCUIntPort {

   public Cuestionario crearCuestionario(Cuestionario objCuestionario);

   public List<Cuestionario> listarCuestionarios(String titulo);

}
