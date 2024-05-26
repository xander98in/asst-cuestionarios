package co.edu.unicauca.asst.cuestionarios.asstcuestionarios.infraestructura.input.controllerGestionarDocentes.DTORespuesta;

import java.util.List;

import co.edu.unicauca.asst.cuestionarios.asstcuestionarios.dominio.commons.enums.TipoIdentificacion;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class DocenteDTORespuesta {

    private TipoIdentificacion tipoIdentificacion;
    private String numeroIdentificacion;
    private String nombres;
    private String apellidos;
    private String correo;
    private String vinculacion;
    private TelefonoDTORespuesta objTelefono;
    private List<DepartamentoDTORespuesta> departamentos;

}
