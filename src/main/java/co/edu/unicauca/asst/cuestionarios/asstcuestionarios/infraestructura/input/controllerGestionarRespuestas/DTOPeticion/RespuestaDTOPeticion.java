package co.edu.unicauca.asst.cuestionarios.asstcuestionarios.infraestructura.input.controllerGestionarRespuestas.DTOPeticion;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RespuestaDTOPeticion {

    private String descripcion;
    private DocenteDTOPeticion objDocente;
    private CuestionarioDTOPeticion objCuestionario;
    private PreguntaDTOPeticion objPregunta;

}
