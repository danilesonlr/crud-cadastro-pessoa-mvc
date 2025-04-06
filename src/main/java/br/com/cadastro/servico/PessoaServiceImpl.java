package br.com.cadastro.servico;

import br.com.cadastro.config.exception.ValidationBusiness;
import br.com.cadastro.domain.dto.PessoaDTO;
import br.com.cadastro.domain.dto.PessoaDTORecord;
import br.com.cadastro.domain.mapper.PessoaMapper;
import br.com.cadastro.repository.PessoaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PessoaServiceImpl implements PessoaServico{
    public static final String PESSOA_NAO_ENCONTRADA = "Pessoa não encontrada.";
    private final PessoaRepository pessoaRepository;
    private final PessoaMapper pessoaMapper;

    @Override
    public void salvar(PessoaDTO pessoa) {
        pessoaRepository.save(pessoaMapper.toEntity(pessoa));
    }

    @Override
    public PessoaDTO buscar(Long id) {
        return pessoaMapper.toDTO(pessoaRepository.findById(id)
                .orElseThrow(() -> new ValidationBusiness(PESSOA_NAO_ENCONTRADA)));
    }

    @Override
    public List<PessoaDTO> buscarTodos() {
        return pessoaRepository.findAll()
                .stream()
                .map(pessoaMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void alterar(Long id, PessoaDTO pessoaDTO) {
        pessoaRepository.findById(id)
                .map(p ->{
                    p.setNome(pessoaDTO.getNome());
                    p.setTelefone(pessoaDTO.getTelefone());
                    p.setDataNascimento(pessoaDTO.getDataNascimento());
                    p.setCpf(pessoaDTO.getCpf());
                    return pessoaRepository.save(p);
                }).orElseThrow(() -> new ValidationBusiness(PESSOA_NAO_ENCONTRADA));
    }

    @Override
    public void excluir(Long id) {
        pessoaRepository.deleteById(id);
    }
}
