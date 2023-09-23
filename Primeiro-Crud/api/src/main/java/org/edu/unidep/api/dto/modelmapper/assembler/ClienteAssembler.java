package org.edu.unidep.api.dto.modelmapper.assembler;

import java.util.List;
import java.util.stream.Collectors;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.core.UriInfo;

import org.edu.unidep.api.dto.modelmapper.request.ClienteRequest;
import org.edu.unidep.api.dto.modelmapper.response.ClienteResponse;
import org.edu.unidep.api.hypermedia.ApiLinks;
import org.edu.unidep.domain.model.Cliente;
import org.modelmapper.ModelMapper;

@ApplicationScoped
public class ClienteAssembler {

	@Inject
	private ModelMapper modelMapper;
	
	@Inject
	private ApiLinks apiLinks;
	
	public Cliente toDomainObject(ClienteRequest clienteInput) {
		return modelMapper.map(clienteInput, Cliente.class);
	}
	
	public ClienteResponse toModel(Cliente cliente, UriInfo uriInfo) {
		ClienteResponse clienteResponse = modelMapper.map(cliente, ClienteResponse.class);
		clienteResponse.addLink(apiLinks.linkToClientesListar(uriInfo));
		clienteResponse.addLink(apiLinks.linkToClientesBuscar(uriInfo, cliente.getId()));
		clienteResponse.addLink(apiLinks.linkToClientesAtualizar(uriInfo, cliente.getId()));
		clienteResponse.addLink(apiLinks.linkToClientesRegistrar(uriInfo));
		clienteResponse.addLink(apiLinks.linkToClientesExcluir(uriInfo, cliente.getId()));
		return clienteResponse;
	}
	
	public List<ClienteResponse> toCollectionModel(List<Cliente> clientes, UriInfo uriInfo){
		return clientes.stream()
				.map(cliente -> toModel(cliente, uriInfo))
				.collect(Collectors.toList());
	}
}
