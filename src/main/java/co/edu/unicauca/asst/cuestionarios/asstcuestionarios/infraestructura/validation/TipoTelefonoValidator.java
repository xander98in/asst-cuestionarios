package co.edu.unicauca.asst.cuestionarios.asstcuestionarios.infraestructura.validation;

import co.edu.unicauca.asst.cuestionarios.asstcuestionarios.dominio.commons.enums.TipoTelefono;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class TipoTelefonoValidator implements ConstraintValidator<ValidTipoTelefono, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) {
            return false;
        }

        try {
            TipoTelefono.valueOf(value);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    } 
}
