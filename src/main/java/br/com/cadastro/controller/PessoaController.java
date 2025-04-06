package br.com.cadastro.controller;

import br.com.cadastro.domain.dto.PessoaDTO;
import br.com.cadastro.domain.dto.PessoaDTORecord;
import br.com.cadastro.servico.PessoaServico;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
public class PessoaController {

    private final PessoaServico pessoaServico;

    @PostMapping("/salvar")
    @ResponseStatus(HttpStatus.CREATED)
    public void salvarPessoa(@Valid PessoaDTO pessoa){
        pessoaServico.salvar(pessoa);
    }

    @GetMapping("/buscar-todos")
    public List<PessoaDTO> buscarTodos(){
        return pessoaServico.buscarTodos();
    }

    @GetMapping("/buscar/{idPessoa}")
    public PessoaDTO buscarPessoa(@PathVariable Long idPessoa){
        return pessoaServico.buscar(idPessoa);
    }

    @PostMapping("/alterar/{idPessoa}")
    public void alterarPessoa(@PathVariable Long idPessoa,
                              @RequestBody @Valid PessoaDTO pessoa){
        pessoaServico.alterar(idPessoa, pessoa);
    }

    @DeleteMapping("/delete/{idPessoa}")
    public void deletarPesso(@PathVariable Long idPessoa){
        pessoaServico.excluir(idPessoa);
    }
}
