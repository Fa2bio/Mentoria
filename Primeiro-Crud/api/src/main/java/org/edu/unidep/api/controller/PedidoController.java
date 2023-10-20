package org.edu.unidep.api.controller;

import java.time.LocalDate;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.parameters.Parameter;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.edu.unidep.api.dto.modelmapper.assembler.PedidoAssembler;
import org.edu.unidep.api.dto.modelmapper.request.PedidoRequest;
import org.edu.unidep.api.dto.modelmapper.response.PedidoResponse;
import org.edu.unidep.api.exceptionhandler.ExceptionMessage;
import org.edu.unidep.domain.filter.PedidoFilter;
import org.edu.unidep.domain.model.Pedido;
import org.edu.unidep.domain.service.PedidoService;

@Path("/pedidos")
@Tag(name = "Pedido")
public class PedidoController {

	@Inject
	private PedidoService pedidoService;
	
	@Inject
	private PedidoAssembler pedidoAssembler;
	
	@GET
	@Path("/listar")
	@Produces(MediaType.APPLICATION_JSON)
	@Operation(description = "Listar Todos Os Pedidos")
	@APIResponses({
		@APIResponse(responseCode = "200", description = "Ok"),
		@APIResponse(responseCode = "204", description = "No Content")
	})
	public Response listarTodos(@Context UriInfo uriInfo) {
		List<Pedido> pedidos = pedidoService.listarTodosPedido();
		if(pedidos.isEmpty()) return Response.status(Status.NO_CONTENT).build();
		List<PedidoResponse> pedidosResponse = pedidoAssembler.toCollectionResponse(pedidos, uriInfo);
		return Response.ok(pedidosResponse).build();
	}
	
	@GET
	@Path("/listarpeladadata/{data}")
	@Produces(MediaType.APPLICATION_JSON)
	@Operation(description = "Lista Pedidos Por Data")
	@APIResponses({
		@APIResponse(responseCode = "200", description = "Ok"),
		@APIResponse(responseCode = "404", description = "Pedido Não Encontrado", content = 
			@Content(schema = @Schema(implementation = ExceptionMessage.class)))
	})
	public Response listarPelaData(
			@Parameter(description = "data", example = "2023-08-30", required = true)
			@PathParam("data") String data,
			@Context UriInfo uriInfo) {
		
		LocalDate localdata = LocalDate.parse(data);
		List<Pedido> pedidos = pedidoService.listarPelaData(localdata);
		if(pedidos.isEmpty()) return Response.status(Status.NO_CONTENT).build();
		List<PedidoResponse> pedidosResponse = pedidoAssembler.toCollectionResponse(pedidos, uriInfo);
		return Response.ok(pedidosResponse).build();
	}
	
	@GET
	@Path("/listarpelonomecliente/{nome}")
	@Produces(MediaType.APPLICATION_JSON)
	@Operation(description = "Lista Pedidos Por Nome Do Cliente")
	@APIResponses({
		@APIResponse(responseCode = "200", description = "Ok"),
		@APIResponse(responseCode = "404", description = "Pedido Não Encontrado", content = 
			@Content(schema = @Schema(implementation = ExceptionMessage.class)))
	})
	public Response listarPeloNomeCliente(
			@Parameter(description = "nome", example = "Fábio", required = true)
			@PathParam("nome") String nome,
			@Context UriInfo uriInfo) {
		
		List<Pedido> pedidos = pedidoService.listarPeloNomeCliente(nome);
		if(pedidos.isEmpty()) return Response.status(Status.NO_CONTENT).build();
		List<PedidoResponse> pedidosResponse = pedidoAssembler.toCollectionResponse(pedidos, uriInfo);
		return Response.ok(pedidosResponse).build();
	}
	
	@GET
	@Path("/listarpelonomefuncionario/{nome}")
	@Produces(MediaType.APPLICATION_JSON)
	@Operation(description = "Lista Pedidos Por Nome Do Funcionario")
	@APIResponses({
		@APIResponse(responseCode = "200", description = "Ok"),
		@APIResponse(responseCode = "404", description = "Pedido Não Encontrado", content = 
			@Content(schema = @Schema(implementation = ExceptionMessage.class)))
	})
	public Response listarPeloNomeFuncionario(
			@Parameter(description = "nome", example = "Paulo", required = true)
			@PathParam("nome") String nome,
			@Context UriInfo uriInfo) {
		
		List<Pedido> pedidos = pedidoService.listarPeloNomeFuncionario(nome);
		if(pedidos.isEmpty()) return Response.status(Status.NO_CONTENT).build();
		List<PedidoResponse> pedidosResponse = pedidoAssembler.toCollectionResponse(pedidos, uriInfo);
		return Response.ok(pedidosResponse).build();
	}
	
	@GET
	@Path("/listarcomfiltro")
	@Produces(MediaType.APPLICATION_JSON)
	public Response listarComFiltro(@RequestBody PedidoFilter pedidoFilter, @Context UriInfo uriInfo) {
		List<Pedido> pedidos = pedidoService.listarComFiltro(pedidoFilter);
		if(pedidos.isEmpty()) return Response.status(Status.NO_CONTENT).build();
		List<PedidoResponse> pedidosResponse = pedidoAssembler.toCollectionResponse(pedidos, uriInfo);
		return Response.ok(pedidosResponse).build();
	}
	
	@GET
	@Path("/buscar/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Operation(description = "Busca Pedidos Por Id")
	@APIResponses({
		@APIResponse(responseCode = "200", description = "Ok"),
		@APIResponse(responseCode = "404", description = "Pedido Não Encontrado", content = 
			@Content(schema = @Schema(implementation = ExceptionMessage.class)))
	})
	public Response buscarPedido(
			@Parameter(description = "Id Do Pedido", example = "1", required = true)
			@PathParam("id") Long id,
			@Context UriInfo uriInfo) {
		Pedido pedido = pedidoService.buscarOuFalhar(id);
		PedidoResponse pedidoResponse = pedidoAssembler.toResponse(pedido, uriInfo);
		return Response.ok(pedidoResponse).build();
	}
	
	@GET
	@Path("/buscarpelocodigopedido/{codigo}")
	@Produces(MediaType.APPLICATION_JSON)
	@Operation(description = "Busca Pedidos Por Código")
	@APIResponses({
		@APIResponse(responseCode = "200", description = "Ok"),
		@APIResponse(responseCode = "404", description = "Pedido Não Encontrado", content = 
			@Content(schema = @Schema(implementation = ExceptionMessage.class)))
	})
	public Response buscarPedidoPeloCodigo(
			@Parameter(description = "Código Do Pedido", example = "fe7d285e-3c62-4940-a1c1-411f2b1628c1", required = true)
			@PathParam("codigo") String codigo,
			@Context UriInfo uriInfo) {
		Pedido pedido = pedidoService.buscarPeloCodigo(codigo);
		PedidoResponse pedidoResponse = pedidoAssembler.toResponse(pedido, uriInfo);
		return Response.ok(pedidoResponse).build();
	}
	
	@POST
	@Path("/registrar")
	@Produces(MediaType.APPLICATION_JSON)
	@Operation(description = "Busca Pedidos Por Código")
	@APIResponses({
		@APIResponse(responseCode = "201", description = "Pedido Registrado"),
		@APIResponse(responseCode = "400", description = "Requisição Não Entendida", content = 
			@Content(schema = @Schema(implementation = ExceptionMessage.class)))
	})
	public Response registrar(			
			@RequestBody(description = "body", required = true)
			PedidoRequest pedidoRequest) {
		
		pedidoService.validarPedidoRequest(pedidoRequest);
		pedidoService.salvarPedido(pedidoRequest);
		return Response.status(Status.CREATED).build();
	}

}
