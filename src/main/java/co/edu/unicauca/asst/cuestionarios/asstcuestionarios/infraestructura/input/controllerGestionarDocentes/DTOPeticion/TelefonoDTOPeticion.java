package co.edu.unicauca.asst.cuestionarios.asstcuestionarios.infraestructura.input.controllerGestionarDocentes.DTOPeticion;

import co.edu.unicauca.asst.cuestionarios.asstcuestionarios.infraestructura.validation.ValidTipoTelefono;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TelefonoDTOPeticion {

    @NotNull(message = "{telefono.tipo_telefono.not_null}")
    @ValidTipoTelefono(message = "{telefono.tipo_telefono.valid_tipo_telefono}")
    private String tipoTelefono;

    @NotEmpty(message = "{telefono.numero.empty}")
    @Pattern(regexp = "3\\d{9}", message = "{telefono.numero.pattern}")
    private String numero;

}
