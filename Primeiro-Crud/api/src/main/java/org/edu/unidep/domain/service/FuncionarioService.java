package org.edu.unidep.domain.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

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
	public void salvarFuncionario(Funcionario Funcionario) {
		funcionarioRepository.salvar(Funcionario);
	}
	
	@Transactional
	public void atualizarFuncionario(Long funcionarioId, Funcionario funcionarioAtualizado) {
		Funcionario funcionarioEncontrado = buscarOuFalhar(funcionarioId);
		funcionarioEncontrado.setNome(funcionarioAtualizado.getNome());
		funcionarioEncontrado.setCpf(funcionarioAtualizado.getCpf());
		funcionarioEncontrado.setEndereco(funcionarioAtualizado.getEndereco());
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
