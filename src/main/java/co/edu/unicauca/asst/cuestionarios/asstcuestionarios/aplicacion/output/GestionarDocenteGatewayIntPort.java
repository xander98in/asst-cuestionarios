package co.edu.unicauca.asst.cuestionarios.asstcuestionarios.aplicacion.output;

import java.util.List;

import co.edu.unicauca.asst.cuestionarios.asstcuestionarios.dominio.modelos.Docente;

public interface GestionarDocenteGatewayIntPort {

    public Boolean existeDocentePorIdentificacion(String numeroIdentificacion);

    public Boolean existeDocentePorCorreo(String correo);

    public Docente guardarDocente(Docente objDocente);

    public List<Docente> listarDocentes();

}
