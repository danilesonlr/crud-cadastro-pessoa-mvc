package br.com.cadastro.domain.dto;

import br.com.cadastro.util.Telefone;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PessoaDTO {
    @Schema(hidden = true)
    private Long id;
    @NotBlank(message = "Nome é obrigatório.")
    private String nome;
    @NotBlank(message = "Telefone é obrigatório.")
    @Telefone
    private String telefone;
    @NotNull(message = "Data de nascimento é obrigatório.")
    private LocalDate dataNascimento;
    @NotBlank(message = "CPF é obrigatório.")
    @CPF(message = "CPF inválido.")
    private String cpf;
}
