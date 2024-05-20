package co.edu.unicauca.asst.cuestionarios.asstcuestionarios.dominio.modelos;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Pregunta {

    private Integer idPregunta;
    private String enunciado;
    private List<Respuesta> respuestas;
    private Cuestionario objCuestionario;
    private TipoPregunta objTipoPregunta;

    public Pregunta() {

    }

}
