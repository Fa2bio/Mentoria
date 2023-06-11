package org.edu.unidep.api.controller;

import java.time.LocalDate;
import java.util.List;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.edu.unidep.api.dto.assembler.PedidoAssembler;
import org.edu.unidep.api.dto.model.PedidoModel;
import org.edu.unidep.api.dto.request.PedidoRequest;
import org.edu.unidep.api.dto.response.PedidoResponse;
import org.edu.unidep.domain.model.Pedido;
import org.edu.unidep.domain.service.PedidoService;

@Path("/pedidos")
public class PedidoController {

	@Inject
	private PedidoService pedidoService;
	
	@Inject
	private PedidoAssembler pedidoAssembler;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response listarTodos() {
		List<Pedido> pedidos = pedidoService.listar();
		if(pedidos.isEmpty()) return Response.status(Response.Status.NO_CONTENT).build();
		List<PedidoResponse> pedidosResponse = pedidoAssembler.toCollectionResponse(pedidos);
		return Response.ok(pedidosResponse).build();
	}
	
	@GET
	@Path("/listarpeladata/{data}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response listarPelaData(@PathParam("data") String data) {
		LocalDate localDate = LocalDate.parse(data);
		List<Pedido> pedidos = pedidoService.listarPelaData(localDate);
		if(pedidos.isEmpty()) return Response.status(Response.Status.NO_CONTENT).build();
		List<PedidoResponse> pedidosResponse = pedidoAssembler.toCollectionResponse(pedidos);
		return Response.ok(pedidosResponse).build();
	}
	
	@GET
	@Path("/listarpelonome/{nome}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response listarPeloNome(@PathParam("nome") String nome) {
		List<Pedido> pedidos = pedidoService.listarPeloNomeCliente(nome);
		if(pedidos.isEmpty()) return Response.status(Response.Status.NO_CONTENT).build();
		List<PedidoResponse> pedidosResponse = pedidoAssembler.toCollectionResponse(pedidos);
		return Response.ok(pedidosResponse).build();
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response buscarPeloCodigo(@PathParam("id") Long id) {
		Pedido pedido = pedidoService.buscarPeloCodigo(id);
		PedidoResponse pedidoResponse = pedidoAssembler.toResponse(pedido);
		return Response.ok(pedidoResponse).build();
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response criar(@RequestBody @Valid PedidoRequest pedidoRequest) {
		PedidoModel pedidoModel = PedidoRequest.toModel(pedidoRequest);
		pedidoService.criar(pedidoModel);
		return Response.status(Status.CREATED).build();
	}
}
