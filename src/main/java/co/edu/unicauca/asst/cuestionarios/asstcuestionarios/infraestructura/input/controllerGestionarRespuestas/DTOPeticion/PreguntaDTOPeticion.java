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
public class PreguntaDTOPeticion {
    @NotNull(message = "{pregunta.id_pregunta.not_null}")
    @Positive(message = "{pregunta.id_pregunta.positive}")
    private Integer idPregunta;

}
