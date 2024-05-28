package co.edu.unicauca.asst.cuestionarios.asstcuestionarios.infraestructura.output.persistencia.entidades;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name = "tipo_preguntas")
public class TipoPreguntaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_pregunta")
    private Integer idTipoPregunta;

    @Column(length = 30)
    private String nombre;

    @Column(length = 90)
    private String descripcion;

    @OneToMany(cascade = { CascadeType.REMOVE },
        fetch = FetchType.EAGER, mappedBy = "objTipoPregunta")
    private List<PreguntaEntity> preguntas;

}

