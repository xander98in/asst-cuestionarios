package co.edu.unicauca.asst.cuestionarios.asstcuestionarios.dominio.modelos;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TipoPregunta {

    private Integer idTipoPregunta;
    private String nombre;
    private String descripcion;
    private List<Pregunta> preguntas;

    public TipoPregunta() {

    }

}
