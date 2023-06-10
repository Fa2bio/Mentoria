package org.edu.unidep.domain.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

import org.edu.unidep.api.dto.model.ClienteModel;
import org.edu.unidep.domain.model.Cliente;
import org.edu.unidep.domain.repository.ClienteRepository;

@ApplicationScoped
public class ClienteService {

	@Inject
	private ClienteRepository clienteRepository;
	
	public List<Cliente> listar() {
		return clienteRepository.listar();
	}  
	
	public Cliente buscarPorCodigo(Long id) {
		return clienteRepository.listarClientePeloCodigo(id);
	}
	
    @Transactional
    public void salvar(ClienteModel clienteModel){
    	Cliente cliente = new Cliente();
    	cliente.setNome(clienteModel.nome());
    	cliente.setEmail(clienteModel.email());
        clienteRepository.salvar(cliente);
    }
	
    @Transactional
    public Cliente atualizar(Long id, ClienteModel clienteModel) {
        Cliente clienteEncontrado = buscarPorCodigo(id);
        clienteEncontrado.setNome(clienteModel.nome());
        clienteEncontrado.setEmail(clienteModel.email());
        return clienteEncontrado;
    }
    
	@Transactional
	public void deletarCliente(Long id) {
		Cliente clienteEncontrado = buscarPorCodigo(id);
		clienteRepository.deletar(clienteEncontrado);
	}
}
