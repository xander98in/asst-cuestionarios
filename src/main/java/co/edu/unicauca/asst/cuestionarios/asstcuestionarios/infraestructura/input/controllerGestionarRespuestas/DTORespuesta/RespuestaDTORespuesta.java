package co.edu.unicauca.asst.cuestionarios.asstcuestionarios.infraestructura.input.controllerGestionarRespuestas.DTORespuesta;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RespuestaDTORespuesta {

    private String descripcion;
    private DocenteDTORespuesta objDocente;
    private CuestionarioDTORespuesta objCuestionario;
    private PreguntaDTORespuesta objPregunta;

}
