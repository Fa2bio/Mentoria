package org.edu.unidep.api.dto.assembler;

import java.util.List;
import java.util.stream.Collectors;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.edu.unidep.api.dto.response.ClienteResponse;
import org.edu.unidep.api.dto.response.ClienteResumoResponse;
import org.edu.unidep.domain.model.Cliente;

@ApplicationScoped
public class ClienteAssembler {

	@Inject
	private PedidoAssembler pedidoAssembler;
	
	public ClienteResumoResponse toResumoResponse(Cliente cliente) {
		return new ClienteResumoResponse(
				cliente.getId(),
				cliente.getNome(),
				cliente.getEmail()
		);
	}
	
	public ClienteResponse toResponse(Cliente cliente) {
		return new ClienteResponse(
				cliente.getId(),
				cliente.getNome(),
				cliente.getEmail(),
				pedidoAssembler.toCollectionResumoResponse(cliente.getPedidos())
		);
	}

	public List<ClienteResponse> toCollectionResponse(List<Cliente> Clientes){		
		return Clientes.stream()
				.map(cliente -> toResponse(cliente))
				.collect(Collectors.toList());
	}
	
	public List<ClienteResumoResponse> toCollectionResumoResponse(List<Cliente> Clientes){		
		return Clientes.stream()
				.map(cliente -> toResumoResponse(cliente))
				.collect(Collectors.toList());
	}
}
