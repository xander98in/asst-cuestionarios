package co.edu.unicauca.asst.cuestionarios.asstcuestionarios.aplicacion.input;

import java.util.List;

import co.edu.unicauca.asst.cuestionarios.asstcuestionarios.dominio.modelos.Docente;

public interface GestionarDocenteCUIntPort {

    public Docente crearDocente(Docente objDocente);

    public List<Docente> listarDocentes();

}
