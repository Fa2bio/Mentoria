package org.edu.unidep.domain.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

import org.edu.unidep.api.dto.record.model.FuncionarioModel;
import org.edu.unidep.domain.exception.FuncionarioNaoEncontradoException;
import org.edu.unidep.domain.model.Funcionario;
import org.edu.unidep.domain.repository.FuncionarioRepository;

@ApplicationScoped
public class FuncionarioService {

	@Inject
	private FuncionarioRepository funcionarioRepository;
	
	public List<Funcionario> listarTodosFuncionarios(){
		return funcionarioRepository.listar();
	}
	
	@Transactional
	public void salvarFuncionario(FuncionarioModel funcionarioModel) {
		Funcionario funcionario = new Funcionario();
		funcionario.setNome(funcionarioModel.nome());
		funcionario.setCpf(funcionarioModel.cpf());
		funcionarioRepository.salvar(funcionario);
	}
	
	@Transactional
	public void atualizarFuncionario(Long funcionarioId, FuncionarioModel funcionarioAtualizado) {
		Funcionario funcionarioEncontrado = buscarOuFalhar(funcionarioId);
		funcionarioEncontrado.setNome(funcionarioAtualizado.nome());
		funcionarioEncontrado.setCpf(funcionarioAtualizado.cpf());
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
