package co.edu.unicauca.asst.cuestionarios.asstcuestionarios.infraestructura.output.persistencia.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "respuestas")
public class RespuestaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_respuesta")
    private Integer idRespuesta;

    @Column(length = 30, nullable = false)
    private String descripcion;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="id_persona", nullable = false)
    private DocenteEntity objDocente;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="id_cuestionario", nullable = false)
    private CuestionarioEntity objCuestionario;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_pregunta", nullable = false)
    private PreguntaEntity objPregunta;

}

