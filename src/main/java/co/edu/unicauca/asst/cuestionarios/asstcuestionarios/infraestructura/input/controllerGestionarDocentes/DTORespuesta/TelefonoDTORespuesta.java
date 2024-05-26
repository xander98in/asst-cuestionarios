package co.edu.unicauca.asst.cuestionarios.asstcuestionarios.infraestructura.input.controllerGestionarDocentes.DTORespuesta;

import co.edu.unicauca.asst.cuestionarios.asstcuestionarios.dominio.commons.enums.TipoTelefono;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TelefonoDTORespuesta {

    private TipoTelefono tipoTelefono;
    private String numero;

}
