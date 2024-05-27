package co.edu.unicauca.asst.cuestionarios.asstcuestionarios.infraestructura.validation;

import java.util.Arrays;

import co.edu.unicauca.asst.cuestionarios.asstcuestionarios.dominio.commons.enums.TipoIdentificacion;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class TipoIdentificacionValidator implements ConstraintValidator<ValidTipoIdentificacion, TipoIdentificacion> {

    @Override
    public boolean isValid(TipoIdentificacion value, ConstraintValidatorContext context) {
        if (value == null) {
            return false;
        }
        return Arrays.asList(TipoIdentificacion.values()).contains(value);
    }

}
