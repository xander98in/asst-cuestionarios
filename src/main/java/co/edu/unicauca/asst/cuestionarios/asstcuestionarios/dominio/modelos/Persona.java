package co.edu.unicauca.asst.cuestionarios.asstcuestionarios.dominio.modelos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Persona {

    private Integer idPersona;
    private String tipoIdentificacion;
    private String numeroIdentificacion;
    private String nombres;
    private String apellidos;

    public Persona() {
        
    }
}
