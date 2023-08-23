package org.edu.unidep.domain.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

import org.edu.unidep.domain.exception.ClienteNaoEncontradoException;
import org.edu.unidep.domain.model.Cliente;
import org.edu.unidep.domain.repository.ClienteRepository;

@ApplicationScoped
public class ClienteService {

	@Inject
	private ClienteRepository clienteRepository;
	
	public List<Cliente> listarTodosClientes(){
		return clienteRepository.listar();
	}
	
	public Cliente buscarClientePorId(Long id) {
		return buscarOuFalhar(id);
	}
	
	@Transactional
	public void salvarCliente(Cliente cliente) {
		clienteRepository.salvar(cliente);
	}
	
	@Transactional
	public void atualizarCliente(Long clienteId, Cliente clienteAtualizado) {
		Cliente clienteEncontrado = buscarOuFalhar(clienteId);
		clienteEncontrado.setNome(clienteAtualizado.getNome());
		clienteEncontrado.setCpf(clienteAtualizado.getCpf());
		clienteEncontrado.setEndereco(clienteAtualizado.getEndereco());
	}
	
	@Transactional
	public void excluirCliente(Long id) {
		Cliente clienteEncontrado = buscarOuFalhar(id);
		clienteRepository.deletar(clienteEncontrado);
	}
	
	public Cliente buscarOuFalhar(Long id) {
		return clienteRepository.buscarPorId(id)
				.orElseThrow(() -> new ClienteNaoEncontradoException(id));
	}
	
}
