package org.edu.unidep.domain.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

import org.edu.unidep.domain.exception.ClienteNaoEncontradoException;
import org.edu.unidep.domain.model.Cliente;
import org.edu.unidep.domain.model.Endereco;
import org.edu.unidep.domain.repository.ClienteRepository;

@ApplicationScoped
public class ClienteService {

	@Inject
	private ClienteRepository clienteRepository;
	
	@Inject
	private EnderecoService enderecoService;
	
	public List<Cliente> listarTodosClientes(){
		return clienteRepository.listar();
	}
	
	@Transactional
	public void salvarCliente(Cliente cliente, String cep) {
		Endereco endereco = enderecoService.enderecoViaCep(cep);
		cliente.setEndereco(endereco);
		clienteRepository.salvar(cliente);
	}
	
	@Transactional
	public void atualizarCliente(Long clienteId, Cliente clienteAtualizado, String cep) {
		Endereco endereco = enderecoService.enderecoViaCep(cep);
		Cliente clienteEncontrado = buscarOuFalhar(clienteId);
		clienteEncontrado.setNome(clienteAtualizado.getNome());
		clienteEncontrado.setCpf(clienteAtualizado.getCpf());
		clienteEncontrado.setEndereco(endereco);
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
