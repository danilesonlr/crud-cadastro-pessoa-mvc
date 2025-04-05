package br.com.cadastro.domain.dto;

import br.com.cadastro.util.Telefone;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;

public record PessoaDTO(
        @Schema(hidden = true) Long id,
        String nome,
        @NotBlank(message = "Telefone é obrigatório.")
        @Telefone
        String telefone,
        @NotNull(message = "Data de nascimento e obrigatório.")
        LocalDate dataNascimento,
        @NotBlank(message = "CPF é obrigatório.")
        @CPF(message = "CPF inválido.")
        String CPF) {}
