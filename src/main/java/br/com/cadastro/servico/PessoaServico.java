package br.com.cadastro.servico;

import br.com.cadastro.domain.dto.PessoaDTO;
import br.com.cadastro.domain.dto.PessoaDTORecord;

import java.util.List;

public interface PessoaServico {
    void salvar(PessoaDTO pessoa);
    PessoaDTO buscar(Long id);
    List<PessoaDTO> buscarTodos();
    void alterar(Long id, PessoaDTO pessoaDTO);
    void excluir(Long id);
}
