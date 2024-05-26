package co.edu.unicauca.asst.cuestionarios.asstcuestionarios.dominio.modelos;

import co.edu.unicauca.asst.cuestionarios.asstcuestionarios.dominio.commons.enums.TipoIdentificacion;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Persona {

    private Integer idPersona;
    private TipoIdentificacion tipoIdentificacion;
    private String numeroIdentificacion;
    private String nombres;
    private String apellidos;

    public Persona() {
        
    }
}
