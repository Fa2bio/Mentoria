package org.edu.unidep.api.dto.record.assembler;

import java.util.List;
import java.util.stream.Collectors;

import javax.enterprise.context.ApplicationScoped;

import org.edu.unidep.api.dto.record.response.ClienteResumoResponse;
import org.edu.unidep.domain.model.Cliente;

@ApplicationScoped
public class ClienteRecordAssembler {

	public ClienteResumoResponse toResumoResponse(Cliente cliente) {
		return new ClienteResumoResponse(
				cliente.getNome(),
				cliente.getCpf()
				);				
	}
	
	public List<ClienteResumoResponse> toCollectionResumoResponse(List<Cliente> clientes){
		return clientes.stream()
				.map(cliente -> toResumoResponse(cliente))
				.collect(Collectors.toList());
	}
}
