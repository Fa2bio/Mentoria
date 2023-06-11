package org.edu.unidep.api.dto.assembler;

import java.util.List;
import java.util.stream.Collectors;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.edu.unidep.api.dto.request.PedidoRequest;
import org.edu.unidep.api.dto.response.PedidoResponse;
import org.edu.unidep.api.dto.response.PedidoResumoResponse;
import org.edu.unidep.domain.model.Cliente;
import org.edu.unidep.domain.model.Orcamento;
import org.edu.unidep.domain.model.Pedido;
import org.edu.unidep.domain.service.ClienteService;
import org.edu.unidep.domain.service.OrcamentoService;

@ApplicationScoped
public class PedidoAssembler {

	@Inject 
	private OrcamentoAssembler orcamentoAssembler;
	
	@Inject
	private ClienteAssembler clienteAssembler;
	
	@Inject
	private ClienteService clienteService;
	
	@Inject
	private OrcamentoService orcamentoService;
	
	public Pedido toDomainObject(PedidoRequest pedidoRequest) {
		Pedido pedido = new Pedido();
		pedido.setDataEmissao(pedidoRequest.data());
		
		Cliente cliente = clienteService.buscarPorCodigo(pedidoRequest.cliente().id());
		pedido.setCliente(cliente);
		
		Orcamento orcamento = orcamentoService.buscarPeloCodigo(pedidoRequest.orcamento().id());
		pedido.setOrcamento(orcamento);
		return pedido;
	}
	
	public PedidoResponse toResponse(Pedido pedido) {
		return new PedidoResponse(
				pedido.getId(),
				pedido.getDataEmissao(),
				orcamentoAssembler.toResponse(pedido.getOrcamento()),
				clienteAssembler.toResumoResponse(pedido.getCliente())
				);
	}
	
	public PedidoResumoResponse toResumoResponse(Pedido pedido) {
		return new PedidoResumoResponse(
				pedido.getId(),
				pedido.getDataEmissao(),
				orcamentoAssembler.toResponse(pedido.getOrcamento())
				);
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
