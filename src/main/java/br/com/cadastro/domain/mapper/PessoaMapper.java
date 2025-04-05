package br.com.cadastro.domain.mapper;

import br.com.cadastro.domain.dto.PessoaDTO;
import br.com.cadastro.domain.entities.Pessoa;

public class PessoaMapper {

    public static Pessoa toEntity(PessoaDTO dto) {
        if (dto == null) return null;

        Pessoa pessoa = new Pessoa();
        pessoa.setId(dto.id());
        pessoa.setNome(dto.nome());
        pessoa.setTelefone(dto.telefone());
        pessoa.setDataNascimento(dto.dataNascimento());
        pessoa.setCpf(dto.CPF());
        return pessoa;
    }

    public static PessoaDTO toDTO(Pessoa entity) {
        if (entity == null) return null;

        return new PessoaDTO(
                entity.getId(),
                entity.getNome(),
                entity.getTelefone(),
                entity.getDataNascimento(),
                entity.getCpf()
        );
    }
}
