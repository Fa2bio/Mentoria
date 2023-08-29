package org.edu.unidep.api.dto.modelmapper.assembler;

import java.util.List;
import java.util.stream.Collectors;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.edu.unidep.api.dto.modelmapper.request.ClienteRequest;
import org.edu.unidep.api.dto.modelmapper.response.ClienteResponse;
import org.edu.unidep.domain.model.Cliente;
import org.modelmapper.ModelMapper;

@ApplicationScoped
public class ClienteAssembler {

	@Inject
	private ModelMapper modelMapper;
	
	public Cliente toDomainObject(ClienteRequest clienteInput) {
		return modelMapper.map(clienteInput, Cliente.class);
	}
	
	public ClienteResponse toModel(Cliente cliente) {
		return modelMapper.map(cliente, ClienteResponse.class);
	}
	
	public List<ClienteResponse> toCollectionModel(List<Cliente> clientes){
		return clientes.stream()
				.map(cliente -> toModel(cliente))
				.collect(Collectors.toList());
	}
}
