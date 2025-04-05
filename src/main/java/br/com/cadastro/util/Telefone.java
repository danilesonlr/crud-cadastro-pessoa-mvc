package br.com.cadastro.util;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Constraint(validatedBy = TelefoneValidator.class)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface Telefone {

    String message() default "Telefone inválido. Use o formato (XX)XXXXX-XXXX ou (XX)XXXX-XXXX";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {}; // <- ESTE É O PARAMETRO OBRIGATÓRIO
}

