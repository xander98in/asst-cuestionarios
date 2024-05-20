package co.edu.unicauca.asst.cuestionarios.asstcuestionarios.infraestructura.input.controllerGestionarCuestionarios.DTOPeticion;

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
public class TipoPreguntaDTOPeticion {

    @NotNull(message = "{tipo_pregunta.id_tipo_pregunta.empty}")
    @Positive(message = "{tipo_pregunta.id_tipo_pregunta.positive}")
    private Integer idTipoPregunta;

}
