package br.com.cadastro.domain.mapper;

import br.com.cadastro.domain.dto.PessoaDTO;
import br.com.cadastro.domain.dto.PessoaDTORecord;
import br.com.cadastro.domain.entities.Pessoa;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PessoaMapper {

    private final ModelMapper modelMapper;

    public  Pessoa toEntity(PessoaDTO dto) {
        return dto == null ? null : modelMapper.map(dto, Pessoa.class);
    }

    public PessoaDTO toDTO(Pessoa entity) {
        return entity == null ? null : modelMapper.map(entity, PessoaDTO.class);
    }
}
