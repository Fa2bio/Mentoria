package org.edu.unidep.domain.service;

import java.util.List;
import java.util.Set;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.PersistenceException;
import javax.transaction.Transactional;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;

import org.edu.unidep.api.dto.record.model.FuncionarioModel;
import org.edu.unidep.api.dto.record.request.FuncionarioRequest;
import org.edu.unidep.domain.exception.CpfEmUsoException;
import org.edu.unidep.domain.exception.FuncionarioNaoEncontradoException;
import org.edu.unidep.domain.model.Endereco;
import org.edu.unidep.domain.model.Funcionario;
import org.edu.unidep.domain.repository.FuncionarioRepository;

@ApplicationScoped
public class FuncionarioService {

	@Inject
	private FuncionarioRepository funcionarioRepository;
	
	@Inject
	private EnderecoService enderecoService;
	
	@Inject
	private Validator validator;
	
	public void validarFuncionarioRequest(FuncionarioRequest funcionarioRequest) {
		Set<ConstraintViolation<FuncionarioRequest>> constraintViolations = validator.validate(funcionarioRequest);
		if(constraintViolations.isEmpty()) return;
		else throw new ConstraintViolationException(constraintViolations);
	}
	
	public List<Funcionario> listarTodosFuncionarios(){
		return funcionarioRepository.listar();
	}
	
	@Transactional
	public void salvarFuncionario(FuncionarioModel funcionarioModel) {
		try {
			Endereco endereco = enderecoService.enderecoViaCep(funcionarioModel.cep());
			Funcionario funcionario = new Funcionario();
			funcionario.setNome(funcionarioModel.nome());
			funcionario.setCpf(funcionarioModel.cpf());
			funcionario.setEndereco(endereco);
			funcionarioRepository.salvar(funcionario);
		} catch (PersistenceException e) {
			throw new CpfEmUsoException(funcionarioModel.cpf());
		}
	}
	
	@Transactional
	public void atualizarFuncionario(Long funcionarioId, FuncionarioModel funcionarioAtualizado) {
		Endereco endereco = enderecoService.enderecoViaCep(funcionarioAtualizado.cep());
		Funcionario funcionarioEncontrado = buscarOuFalhar(funcionarioId);
		funcionarioEncontrado.setNome(funcionarioAtualizado.nome());
		funcionarioEncontrado.setCpf(funcionarioAtualizado.cpf());
		funcionarioEncontrado.setEndereco(endereco);
	}
	
	@Transactional
	public void excluirFuncionario(Long id) {
		Funcionario FuncionarioEncontrado = buscarOuFalhar(id);
		funcionarioRepository.deletar(FuncionarioEncontrado);
	}
	
	public Funcionario buscarOuFalhar(Long id) {
		return funcionarioRepository.buscarPorId(id)
				.orElseThrow(() -> new FuncionarioNaoEncontradoException(id));
	}
}
