package co.edu.unicauca.asst.cuestionarios.asstcuestionarios.dominio.modelos;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Cuestionario {
    
    private Integer idCuestionario;
    private String titulo;
    private String descripcion;
    private List<Pregunta> preguntas;
    private List<Respuesta> respuestas;

    public Cuestionario() {
    }
}
