package org.edu.unidep.api.dto.modelmapper.assembler;

import java.util.List;
import java.util.stream.Collectors;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.core.UriInfo;

import org.edu.unidep.api.dto.modelmapper.response.PedidoResponse;
import org.edu.unidep.api.dto.modelmapper.response.PedidoResumoResponse;
import org.edu.unidep.api.hypermedia.ApiLinks;
import org.edu.unidep.domain.model.Pedido;
import org.modelmapper.ModelMapper;

@ApplicationScoped
public class PedidoAssembler {
	
	@Inject
	private ModelMapper modelMapper;

	@Inject
	private ApiLinks apiLinks;
	
	public PedidoResponse toResponse(Pedido pedido, UriInfo uriInfo) {
		PedidoResponse pedidoResponse = modelMapper.map(pedido, PedidoResponse.class);
		pedidoResponse.addLink(apiLinks.linkToPedidosListar(uriInfo));
		pedidoResponse.addLink(apiLinks.linkToPedidosListarData(uriInfo, pedido.getDataEmissao().toString()));
		pedidoResponse.addLink(apiLinks.linkToPedidosListarNomeCliente(uriInfo, pedido.getCliente().getNome()));
		pedidoResponse.addLink(apiLinks.linkToPedidosListarNomeFuncionario(uriInfo, pedido.getFuncionario().getNome()));
		pedidoResponse.addLink(apiLinks.linkToPedidosListarComFiltro(uriInfo));
		pedidoResponse.addLink(apiLinks.linkToPedidosBuscar(uriInfo, pedido.getId()));
		pedidoResponse.addLink(apiLinks.linkToPedidosBuscarPeloCodigo(uriInfo, pedido.getUuidCode()));
		pedidoResponse.addLink(apiLinks.linkToPedidosRegistrar(uriInfo));
		return pedidoResponse;
	}
	
	public PedidoResumoResponse toResumoResponse (Pedido pedido, UriInfo uriInfo) {
		PedidoResumoResponse pedidoResponse = modelMapper.map(pedido, PedidoResumoResponse.class);
		pedidoResponse.addLink(apiLinks.linkToPedidosListar(uriInfo));
		pedidoResponse.addLink(apiLinks.linkToPedidosListarData(uriInfo, pedido.getDataEmissao().toString()));
		pedidoResponse.addLink(apiLinks.linkToPedidosListarNomeCliente(uriInfo, pedido.getCliente().getNome()));
		pedidoResponse.addLink(apiLinks.linkToPedidosListarNomeFuncionario(uriInfo, pedido.getFuncionario().getNome()));
		pedidoResponse.addLink(apiLinks.linkToPedidosListarComFiltro(uriInfo));
		pedidoResponse.addLink(apiLinks.linkToPedidosBuscar(uriInfo, pedido.getId()));
		pedidoResponse.addLink(apiLinks.linkToPedidosBuscarPeloCodigo(uriInfo, pedido.getUuidCode()));
		pedidoResponse.addLink(apiLinks.linkToPedidosRegistrar(uriInfo));
		return pedidoResponse;
	}
	
	public List<PedidoResponse> toCollectionResponse(List<Pedido> pedidos, UriInfo uriInfo){
		return pedidos.stream()
				.map(pedido -> toResponse(pedido, uriInfo))
				.collect(Collectors.toList());
	}
	
	public List<PedidoResumoResponse> toCollectionResumoResponse(List<Pedido> pedidos, UriInfo uriInfo){
		return pedidos.stream()
				.map(pedido -> toResumoResponse(pedido, uriInfo))
				.collect(Collectors.toList());
	}
	
}
