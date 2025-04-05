package br.com.cadastro.servico;

import br.com.cadastro.domain.dto.PessoaDTO;
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

    @Override
    public void salvar(PessoaDTO pessoa) {
        pessoaRepository.save(PessoaMapper.toEntity(pessoa));
    }

    @Override
    public PessoaDTO buscar(Long id) {
        return PessoaMapper.toDTO(pessoaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(PESSOA_NAO_ENCONTRADA)));
    }

    @Override
    public List<PessoaDTO> buscarTodos() {
        return pessoaRepository.findAll()
                .stream()
                .map(PessoaMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void alterar(Long id, PessoaDTO pessoaDTO) {
        pessoaRepository.findById(id)
                .map(p ->{
                    p.setNome(pessoaDTO.nome());
                    p.setTelefone(pessoaDTO.telefone());
                    p.setDataNascimento(pessoaDTO.dataNascimento());
                    return pessoaRepository.save(p);
                }).orElseThrow(() -> new RuntimeException(PESSOA_NAO_ENCONTRADA));
    }

    @Override
    public void excluir(Long id) {
        pessoaRepository.deleteById(id);
    }
}
