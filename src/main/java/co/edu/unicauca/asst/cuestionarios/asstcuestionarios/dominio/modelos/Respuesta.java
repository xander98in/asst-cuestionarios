package co.edu.unicauca.asst.cuestionarios.asstcuestionarios.dominio.modelos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Respuesta {

    private Integer idRespuesta;
    private String descripcion;
    private Docente objDocente;
    private Pregunta objPregunta;

    public Respuesta() {

    }

}
