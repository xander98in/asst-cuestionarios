package co.edu.unicauca.asst.cuestionarios.asstcuestionarios.aplicacion.output;

import java.util.List;

import co.edu.unicauca.asst.cuestionarios.asstcuestionarios.dominio.modelos.Cuestionario;

public interface GestionarCuestionarioGatewayIntPort {

    public boolean existeCuestionarioPorTitulo(String titulo);

    public Cuestionario guardarCuestionario(Cuestionario objCuestionario);

    public List<Cuestionario> listarCuestionarios(String titulo);

}
