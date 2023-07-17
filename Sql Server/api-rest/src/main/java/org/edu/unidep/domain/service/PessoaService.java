package org.edu.unidep.domain.service;

import java.util.List;
import java.util.Set;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;

import org.edu.unidep.api.command.PessoaCommand;
import org.edu.unidep.api.rest.request.PessoaRequest;
import org.edu.unidep.domain.exception.PessoaNaoEncontradaException;
import org.edu.unidep.domain.model.Pessoa;
import org.edu.unidep.domain.repository.PessoaRepository;

@ApplicationScoped
public class PessoaService {

	@Inject
    private PessoaRepository pessoaRepository;
    
	@Inject
	private Validator validator;

    @Transactional
    public void salvar(PessoaCommand command){
        Pessoa pessoa = new Pessoa();
        pessoa.setNome(command.nome());
        pessoa.setDataAniversario(command.dataAniversario());
        pessoa.setTipoSanguineo(command.tipoSanguineo());
        pessoa.setEndereco(command.endereco());
        pessoa.setCpf(command.cpf());
        pessoaRepository.salvar(pessoa);
    }

    @Transactional
    public PessoaCommand atualizar(Long id, PessoaCommand command) {
        Pessoa pessoaEncontrada = acharOuFalhar(id);
        pessoaEncontrada.setNome(command.nome());
        pessoaEncontrada.setDataAniversario(command.dataAniversario());
        pessoaEncontrada.setTipoSanguineo(command.tipoSanguineo());
        pessoaEncontrada.setEndereco(command.endereco());
        pessoaEncontrada.setCpf(command.cpf());
        return command;
    }
    
	@Transactional
	public void deletarPessoa(Long id) {
		Pessoa pessoaEncontrada = acharOuFalhar(id);
		pessoaRepository.deletar(pessoaEncontrada);
	}
	
    public List<Pessoa> listar() {
        return pessoaRepository.listarPessoas();
    }
    
	public Pessoa acharOuFalhar(Long id) {
		return pessoaRepository.listarPessoaPeloCodigo(id)
				.orElseThrow(()-> new PessoaNaoEncontradaException(id));
	}

	public void validarPessoaRequest(PessoaRequest pessoaRequest) {
		Set<ConstraintViolation<PessoaRequest>> constraintViolations = validator.validate(pessoaRequest);
		if(constraintViolations.isEmpty()) return;
		else throw new ConstraintViolationException(constraintViolations);
	}
}
