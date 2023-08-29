package org.edu.unidep.api.dto.modelmapper.assembler;

import java.util.List;
import java.util.stream.Collectors;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.edu.unidep.api.dto.modelmapper.response.PedidoResponse;
import org.edu.unidep.api.dto.modelmapper.response.PedidoResumoResponse;
import org.edu.unidep.domain.model.Pedido;
import org.modelmapper.ModelMapper;

@ApplicationScoped
public class PedidoAssembler {
	
	@Inject
	private ModelMapper modelMapper;

	public PedidoResponse toResponse(Pedido pedido) {
		return modelMapper.map(pedido, PedidoResponse.class);
	}
	
	public PedidoResumoResponse toResumoResponse (Pedido pedido) {
		return modelMapper.map(pedido, PedidoResumoResponse.class);
	}
	
	public List<PedidoResponse> toCollectionResponse(List<Pedido> pedidos){
		return pedidos.stream()
				.map(pedido -> toResponse(pedido))
				.collect(Collectors.toList());
	}
	
	public List<PedidoResumoResponse> toCollectionResumoResponse(List<Pedido> pedidos){
		return pedidos.stream()
				.map(pedido -> toResumoResponse(pedido))
				.collect(Collectors.toList());
	}
	
}
