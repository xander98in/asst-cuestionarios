package co.edu.unicauca.asst.cuestionarios.asstcuestionarios.infraestructura.input.controllerGestionarCuestionarios.DTOPeticion;

import java.util.List;

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
public class CuestionarioDTOPeticion {

    @NotEmpty(message = "{cuestionario.titulo.empty}")
    @Size(min = 5, max = 50, message = "{cuestionario.titulo.size}")
    private String titulo;

    @NotEmpty(message = "{cuestionario.descripcion.empty}")
    @Size(min = 5, max = 90, message = "{cuestionario.descripcion.size}")
    private String descripcion;
    
    @Valid
    private List<PreguntaDTOPeticion> preguntas;

}
