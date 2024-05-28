package co.edu.unicauca.asst.cuestionarios.asstcuestionarios.infraestructura.output.persistencia.entidades;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
@Table(name = "preguntas")
public class PreguntaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pregunta")
    private Integer idPregunta;

    @Column(length = 90, nullable = false)
    private String enunciado;

    @OneToMany(cascade = { CascadeType.REMOVE }, 
        fetch = FetchType.EAGER, mappedBy = "objPregunta")
    private List<RespuestaEntity> respuestas;

    //Por defecto en asociaciones many to one el fetchType es EAGER
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_cuestionario", nullable = false)
    private CuestionarioEntity objCuestionario;

    //Por defecto en asociaciones many to one el fetchType es EAGER
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_pregunta", nullable = false)
    private TipoPreguntaEntity objTipoPregunta;

}
