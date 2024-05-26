package co.edu.unicauca.asst.cuestionarios.asstcuestionarios.infraestructura.input.controllerGestionarDocentes.DTOPeticion;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class DepartamentoDTOPeticion {

    @NotNull(message = "{departamento.id_departamento.not_null}")
    @Positive(message = "{departamento.id_departamento.positive}")
    private Integer idDepartamento;

}
