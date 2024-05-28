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
public class DocenteDTOPeticion {
    @NotNull(message = "{persona.id_persona.not_null}")
    @Positive(message = "{persona.id_persona.positive}")
    private Integer idPersona;
}
