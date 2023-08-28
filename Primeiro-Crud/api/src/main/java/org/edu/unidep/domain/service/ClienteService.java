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

import org.edu.unidep.api.dto.modelmapper.model.ClienteInputModel;
import org.edu.unidep.domain.exception.ClienteEmUsoException;
import org.edu.unidep.domain.exception.ClienteNaoEncontradoException;
import org.edu.unidep.domain.exception.CpfEmUsoException;
import org.edu.unidep.domain.model.Cliente;
import org.edu.unidep.domain.model.Endereco;
import org.edu.unidep.domain.repository.ClienteRepository;

@ApplicationScoped
public class ClienteService {

	@Inject
	private ClienteRepository clienteRepository;
	
	@Inject
	private EnderecoService enderecoService;
	
	@Inject
	private Validator validator;
	
	
	public void validarClienteRequest(ClienteInputModel clienteInput) {
		Set<ConstraintViolation<ClienteInputModel>> constraintViolations = validator.validate(clienteInput);
		if(constraintViolations.isEmpty()) return;
		else throw new ConstraintViolationException(constraintViolations);
	}
	
	public List<Cliente> listarTodosClientes(){
		return clienteRepository.listar();
	}
	
	@Transactional
	public void salvarCliente(Cliente cliente, String cep) {
		try {
			Endereco endereco = enderecoService.enderecoViaCep(cep);
			cliente.setEndereco(endereco);
			clienteRepository.salvar(cliente);
		} catch (PersistenceException e) {
			throw new CpfEmUsoException(cliente.getCpf());
		}
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
		try {
			Cliente clienteEncontrado = buscarOuFalhar(id);
			clienteRepository.deletar(clienteEncontrado);
		} catch (PersistenceException e) {
			throw new ClienteEmUsoException(id);
		}
	}
	
	public Cliente buscarOuFalhar(Long id) {
		return clienteRepository.buscarPorId(id)
				.orElseThrow(() -> new ClienteNaoEncontradoException(id));
	}
	
}
