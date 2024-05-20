package co.edu.unicauca.asst.cuestionarios.asstcuestionarios.dominio.modelos;

import co.edu.unicauca.asst.cuestionarios.asstcuestionarios.dominio.commons.enums.TipoTelefono;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Telefono {

    private Integer idTelefono;
    private TipoTelefono tipoTelefono;
    private String numero;
    private Docente objPersona;

    public Telefono() {

    }

}
