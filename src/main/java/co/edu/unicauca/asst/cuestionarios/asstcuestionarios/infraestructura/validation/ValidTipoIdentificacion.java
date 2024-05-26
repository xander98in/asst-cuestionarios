package co.edu.unicauca.asst.cuestionarios.asstcuestionarios.infraestructura.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Constraint(validatedBy = TipoIdentificacionValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD})
public @interface ValidTipoIdentificacion {

    String message() default "Tipo de identificación inválido";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
