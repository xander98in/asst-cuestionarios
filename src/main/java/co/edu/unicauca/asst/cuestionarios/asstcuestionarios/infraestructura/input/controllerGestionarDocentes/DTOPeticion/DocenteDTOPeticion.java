package co.edu.unicauca.asst.cuestionarios.asstcuestionarios.infraestructura.input.controllerGestionarDocentes.DTOPeticion;

import java.util.List;

import co.edu.unicauca.asst.cuestionarios.asstcuestionarios.infraestructura.validation.ValidTipoIdentificacion;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class DocenteDTOPeticion {

    @NotNull(message = "{docente.tipo_identificacion.not_null}")
    @ValidTipoIdentificacion(message = "{docente.tipo_identificacion.valid_tipo_identificacion}")
    private String tipoIdentificacion;

    @NotEmpty(message = "{docente.numero_identificacion.empty}")
    @Size(min = 5, max = 10, message = "{docente.numero_identificacion.size}")
    private String numeroIdentificacion;

    @NotEmpty(message = "{docente.nombres.empty}")
    @Size(min = 3, max = 30, message = "{docente.nombres.size}")
    private String nombres;

    @NotEmpty(message = "{docente.apellidos.empty}")
    @Size(min = 3, max = 30, message = "{docente.apellidos.size}")
    private String apellidos;

    @Pattern(regexp = "^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$", message = "{docente.correo.pattern}")
    private String correo;
    
    @NotEmpty(message = "{docente.vinculacion.empty}")
    @Size(min = 5, max = 30, message = "{docente.vinculacion.size}")
    private String vinculacion;

    @Valid
    @NotNull(message = "{docente.obj_telefono.empty}")
    private TelefonoDTOPeticion objTelefono;

    @Valid
    @NotNull(message = "{docente.departamentos.empty}")
    private List<DepartamentoDTOPeticion> departamentos;
}
