package br.com.cadastro.util;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class TelefoneValidator implements ConstraintValidator<Telefone, String> {

    private static final String TELEFONE_REGEX = "^\\(\\d{2}\\)\\d{4,5}-\\d{4}$";

    @Override
    public boolean isValid(String telefone, ConstraintValidatorContext context) {
        if (telefone == null) return false;
        return telefone.matches(TELEFONE_REGEX);
    }
}
