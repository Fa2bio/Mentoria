package org.edu.unidep.api.dto.modelmapper.assembler;

import java.util.List;
import java.util.stream.Collectors;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.edu.unidep.api.dto.modelmapper.model.ClienteInputModel;
import org.edu.unidep.api.dto.modelmapper.model.ClienteModel;
import org.edu.unidep.domain.model.Cliente;
import org.modelmapper.ModelMapper;

@ApplicationScoped
public class ClienteAssembler {

	@Inject
	private ModelMapper modelMapper;
	
	public Cliente toDomainObject(ClienteInputModel clienteInput) {
		return modelMapper.map(clienteInput, Cliente.class);
	}
	
	public ClienteModel toModel(Cliente cliente) {
		return modelMapper.map(cliente, ClienteModel.class);
	}
	
	public List<ClienteModel> toCollectionModel(List<Cliente> clientes){
		return clientes.stream()
				.map(cliente -> toModel(cliente))
				.collect(Collectors.toList());
	}
}
