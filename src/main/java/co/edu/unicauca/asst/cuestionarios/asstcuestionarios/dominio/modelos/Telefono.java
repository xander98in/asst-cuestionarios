package co.edu.unicauca.asst.cuestionarios.asstcuestionarios.dominio.modelos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Telefono {

    private Integer idTelefono;
    private String tipoTelefono;
    private String numero;
    private Docente objPersona;

    public Telefono() {
    }
}
