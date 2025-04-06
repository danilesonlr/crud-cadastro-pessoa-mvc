package br.com.cadastro.domain.mapper;

import br.com.cadastro.domain.dto.PessoaDTORecord;
import br.com.cadastro.domain.entities.Pessoa;

//O model Mapper não funciona entre record e class
public class PessoaMapperRecord {
    public static Pessoa toEntity(PessoaDTORecord dto) {
        if (dto == null) return null;

        Pessoa pessoa = new Pessoa();
        pessoa.setId(dto.id());
        pessoa.setNome(dto.nome());
        pessoa.setTelefone(dto.telefone());
        pessoa.setDataNascimento(dto.dataNascimento());
        pessoa.setCpf(dto.cpf());
        return pessoa;
    }

    public static PessoaDTORecord toDTO(Pessoa entity) {
        if (entity == null) return null;

        return new PessoaDTORecord(
                entity.getId(),
                entity.getNome(),
                entity.getTelefone(),
                entity.getDataNascimento(),
                entity.getCpf()
        );
    }
}

