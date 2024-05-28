package co.edu.unicauca.asst.cuestionarios.asstcuestionarios.infraestructura.input.controllerGestionarRespuestas.DTOPeticion;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RespuestaDTOPeticion {

    @NotEmpty(message = "{respuesta.descripcion.empty}")
    @Size(min = 5, max = 90, message = "{respuesta.descripcion.size}")
    private String descripcion;
    @Valid
    private DocenteDTOPeticion objDocente;
    @Valid
    private CuestionarioDTOPeticion objCuestionario;
    @Valid
    private PreguntaDTOPeticion objPregunta;

}
