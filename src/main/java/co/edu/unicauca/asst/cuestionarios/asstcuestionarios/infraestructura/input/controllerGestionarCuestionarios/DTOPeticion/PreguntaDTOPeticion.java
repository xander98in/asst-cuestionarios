package co.edu.unicauca.asst.cuestionarios.asstcuestionarios.infraestructura.input.controllerGestionarCuestionarios.DTOPeticion;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PreguntaDTOPeticion {

    @NotEmpty(message = "{pregunta.enunciado.empty}")
    @Size(min = 10, max = 90, message = "{pregunta.enunciado.size}")
    private String enunciado;
    
    @Valid
    @NotNull(message = "{pregunta.tipopregunta.empty")
    private TipoPreguntaDTOPeticion objTipoPregunta;

}
