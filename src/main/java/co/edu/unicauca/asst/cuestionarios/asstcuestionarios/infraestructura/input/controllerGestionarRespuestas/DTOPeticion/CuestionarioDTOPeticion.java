package co.edu.unicauca.asst.cuestionarios.asstcuestionarios.infraestructura.input.controllerGestionarRespuestas.DTOPeticion;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CuestionarioDTOPeticion {
    @NotNull(message = "{cuestionario.id_cuestionario.not_null}")
    @Positive(message = "{cuestionario.id_cuestionario.positive}")
    private Integer idCuestionario;

}
