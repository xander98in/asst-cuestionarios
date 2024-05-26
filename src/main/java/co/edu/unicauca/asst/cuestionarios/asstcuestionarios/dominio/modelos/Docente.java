package co.edu.unicauca.asst.cuestionarios.asstcuestionarios.dominio.modelos;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
public class Docente extends Persona {

    private String correo;
    private String vinculacion;
    private Telefono objTelefono;
    private List<Departamento> departamentos;
    private List<Respuesta> respuestas;

    public Docente() {
    }
}
