package co.edu.unicauca.asst.cuestionarios.asstcuestionarios.infraestructura.validation;

import co.edu.unicauca.asst.cuestionarios.asstcuestionarios.dominio.commons.enums.TipoIdentificacion;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class TipoIdentificacionValidator implements ConstraintValidator<ValidTipoIdentificacion, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) {
            return false;
        }

        try {
            TipoIdentificacion.valueOf(value);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    } 

}
