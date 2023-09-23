package org.edu.unidep.api.controller;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
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
import org.edu.unidep.api.dto.modelmapper.assembler.ClienteAssembler;
import org.edu.unidep.api.dto.modelmapper.request.ClienteRequest;
import org.edu.unidep.api.dto.modelmapper.response.ClienteResponse;
import org.edu.unidep.api.exceptionhandler.ExceptionMessage;
import org.edu.unidep.domain.model.Cliente;
import org.edu.unidep.domain.service.ClienteService;

@Path("/clientes")
@Tag(name = "Cliente")
public class ClienteController {

	@Inject
	private ClienteService clienteService;
	
	@Inject
	private ClienteAssembler clienteAssembler;
	
	// Obtem dados do servidor
	@GET
	@Path("/listar")
	@Produces(MediaType.APPLICATION_JSON)
	@Operation(description = "Lista Todos os Clientes")
	@APIResponses({
		@APIResponse(responseCode = "200", description = "Ok"),
		@APIResponse(responseCode = "204", description = "No Content")
	})
	public Response listarTodos(@Context UriInfo uriInfo) {
		List<Cliente> clientes = clienteService.listarTodosClientes();
		if(clientes.isEmpty()) return Response.status(Status.NO_CONTENT).build();
		List<ClienteResponse> clienteResponse = clienteAssembler.toCollectionModel(clientes, uriInfo);
		return Response.ok(clienteResponse).build();
	}
	
	@GET
	@Path("/buscar/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Operation(description = "Busca Um Cliente Por Id")
	@APIResponses({
		@APIResponse(responseCode = "200", description = "Ok"),
		@APIResponse(responseCode = "404", description = "Cliente Não Encontado", content =
				@Content(schema = @Schema(implementation = ExceptionMessage.class)))
		
	})
	public Response buscarCliente(
			@Parameter(description = "Id do Cliente", example = "1", required = true)
			@PathParam("id") Long id,
			@Context UriInfo uriInfo) {
		Cliente cliente = clienteService.buscarOuFalhar(id);
		ClienteResponse clienteResponse = clienteAssembler.toModel(cliente, uriInfo);
		return Response.ok(clienteResponse).build();
	}
	
	// Altera dados de uma instancia presente no servidor
	@PUT	
	@Path("/atualizar/{id}")
	@Produces(MediaType.APPLICATION_JSON)	
	@Operation(description = "Atualiza Um Cliente Por Id")
	@APIResponses({
		@APIResponse(responseCode = "204", description = "Cliente Atualizado"),
		@APIResponse(responseCode = "400", description = "Requisição Não Atendida", content =
				@Content(schema = @Schema(implementation = ExceptionMessage.class))),
		@APIResponse(responseCode = "404", description = "Cliente Não Encontado", content =
				@Content(schema = @Schema(implementation = ExceptionMessage.class)))
		
	})
	public Response atualizarCliente(
			@Parameter(description = "Id do Cliente", example = "1", required = true)
			@PathParam("id") Long id,
			
			@RequestBody(description = "body", required = true)
			ClienteRequest clienteInput) {
		
		clienteService.validarClienteRequest(clienteInput);
		Cliente clienteAtualizado = clienteAssembler.toDomainObject(clienteInput);
		clienteService.atualizarCliente(id, clienteAtualizado, clienteInput.getCep());
		return Response.status(Status.NO_CONTENT).build();
	}

	// Cria uma instancia no servidor
	@POST
	@Path("/registrar")
	@Produces(MediaType.APPLICATION_JSON)
	@Operation(description = "Registra Um Cliente")
	@APIResponses({
		@APIResponse(responseCode = "201", description = "Cliente Registrado"),
		@APIResponse(responseCode = "400", description = "Requisição Não Atendida", content =
				@Content(schema = @Schema(implementation = ExceptionMessage.class)))
		
	})
	public Response registrar(
			@RequestBody(description = "body", required = true)
			ClienteRequest clienteInput) {
		
		clienteService.validarClienteRequest(clienteInput);
		Cliente cliente = clienteAssembler.toDomainObject(clienteInput);
		clienteService.salvarCliente(cliente, clienteInput.getCep());
		return Response.status(Status.CREATED).build();
	}
	
	// Exclui uma instancia do servidor
	@DELETE
	@Path("/excluir/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Operation(description = "Deleta Um Cliente Por Id")
	@APIResponses({
		@APIResponse(responseCode = "204", description = "Cliente Deletado"),
		@APIResponse(responseCode = "404", description = "Cliente Não Encontado", content =
				@Content(schema = @Schema(implementation = ExceptionMessage.class)))
		
	})
	public Response excluir(@PathParam("id") Long id) {
		clienteService.excluirCliente(id);
		return Response.status(Status.NO_CONTENT).build();
	}
		
}
