package org.edu.unidep.api.controller;

import java.time.LocalDate;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.edu.unidep.api.dto.modelmapper.assembler.PedidoAssembler;
import org.edu.unidep.api.dto.modelmapper.request.PedidoRequest;
import org.edu.unidep.api.dto.modelmapper.response.PedidoResponse;
import org.edu.unidep.domain.model.Pedido;
import org.edu.unidep.domain.service.PedidoService;

@Path("/pedidos")
public class PedidoController {

	@Inject
	private PedidoService pedidoService;
	
	@Inject
	private PedidoAssembler pedidoAssembler;
	
	@GET
	@Path("/listar")
	@Produces(MediaType.APPLICATION_JSON)
	public Response listarTodos() {
		List<Pedido> pedidos = pedidoService.listarTodosPedido();
		if(pedidos.isEmpty()) return Response.status(Status.NO_CONTENT).build();
		List<PedidoResponse> pedidosResponse = pedidoAssembler.toCollectionResponse(pedidos);
		return Response.ok(pedidosResponse).build();
	}
	
	@GET
	@Path("/listarpeladadata/{data}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response listarPelaData(@PathParam("data") String data) {
		LocalDate localdata = LocalDate.parse(data);
		List<Pedido> pedidos = pedidoService.listarPelaData(localdata);
		if(pedidos.isEmpty()) return Response.status(Status.NO_CONTENT).build();
		List<PedidoResponse> pedidosResponse = pedidoAssembler.toCollectionResponse(pedidos);
		return Response.ok(pedidosResponse).build();
	}
	
	@GET
	@Path("/listarpelonomecliente/{nome}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response listarPeloNomeCliente(@PathParam("nome") String nome) {
		List<Pedido> pedidos = pedidoService.listarPeloNomeCliente(nome);
		if(pedidos.isEmpty()) return Response.status(Status.NO_CONTENT).build();
		List<PedidoResponse> pedidosResponse = pedidoAssembler.toCollectionResponse(pedidos);
		return Response.ok(pedidosResponse).build();
	}
	
	@GET
	@Path("/listarpelonomefuncionario/{nome}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response listarPeloNomeFuncionario(@PathParam("nome") String nome) {
		List<Pedido> pedidos = pedidoService.listarPeloNomeFuncionario(nome);
		if(pedidos.isEmpty()) return Response.status(Status.NO_CONTENT).build();
		List<PedidoResponse> pedidosResponse = pedidoAssembler.toCollectionResponse(pedidos);
		return Response.ok(pedidosResponse).build();
	}
	
	@GET
	@Path("/buscar/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response buscarPedido(@PathParam("id") Long id) {
		Pedido pedido = pedidoService.buscarOuFalhar(id);
		PedidoResponse pedidoResponse = pedidoAssembler.toResponse(pedido);
		return Response.ok(pedidoResponse).build();
	}
	
	@GET
	@Path("/buscarpelocodigopedido/{codigo}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response buscarPedido(@PathParam("codigo") String codigo) {
		Pedido pedido = pedidoService.buscarPeloCodigo(codigo);
		PedidoResponse pedidoResponse = pedidoAssembler.toResponse(pedido);
		return Response.ok(pedidoResponse).build();
	}
	
	@POST
	@Path("/registrar")
	@Produces(MediaType.APPLICATION_JSON)
	public Response criar(@RequestBody PedidoRequest pedidoRequest) {
		pedidoService.validarPedidoRequest(pedidoRequest);
		pedidoService.salvarPedido(pedidoRequest);
		return Response.status(Status.CREATED).build();
	}

}
