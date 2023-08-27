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
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.edu.unidep.api.dto.modelmapper.assembler.ClienteAssembler;
import org.edu.unidep.api.dto.modelmapper.model.ClienteInputModel;
import org.edu.unidep.api.dto.modelmapper.model.ClienteModel;
import org.edu.unidep.domain.model.Cliente;
import org.edu.unidep.domain.service.ClienteService;

@Path("/clientes")
public class ClienteController {

	@Inject
	private ClienteService clienteService;
	
	@Inject
	private ClienteAssembler clienteAssembler;
	
	// Obtem dados do servidor
	@GET
	@Path("/listar")
	@Produces(MediaType.APPLICATION_JSON)
	public Response listarTodos() {
		List<Cliente> clientes = clienteService.listarTodosClientes();
		if(clientes.isEmpty()) return Response.status(Status.NO_CONTENT).build();
		List<ClienteModel> clienteResponse = clienteAssembler.toCollectionModel(clientes);
		return Response.ok(clienteResponse).build();
	}
	
	@GET
	@Path("/buscar/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response buscarCliente(@PathParam("id") Long id) {
		Cliente cliente = clienteService.buscarOuFalhar(id);
		ClienteModel clienteResponse = clienteAssembler.toModel(cliente);
		return Response.ok(clienteResponse).build();
	}
	
	// Altera dados de uma instancia presente no servidor
	@PUT	
	@Path("/atualizar/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response atualizarCliente(
			@PathParam("id") Long id,
			@RequestBody ClienteInputModel clienteInput) {
		clienteService.validarClienteRequest(clienteInput);
		Cliente clienteAtualizado = clienteAssembler.toDomainObject(clienteInput);
		clienteService.atualizarCliente(id, clienteAtualizado, clienteInput.getCep());
		return Response.status(Status.NO_CONTENT).build();
	}

	// Cria uma instancia no servidor
	@POST
	@Path("/registrar")
	@Produces(MediaType.APPLICATION_JSON)
	public Response registrar(@RequestBody ClienteInputModel clienteInput) {
		clienteService.validarClienteRequest(clienteInput);
		Cliente cliente = clienteAssembler.toDomainObject(clienteInput);
		clienteService.salvarCliente(cliente, clienteInput.getCep());
		return Response.status(Status.CREATED).build();
	}
	
	// Exclui uma instancia do servidor
	@DELETE
	@Path("/excluir/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response excluir(@PathParam("id") Long id) {
		clienteService.excluirCliente(id);
		return Response.status(Status.NO_CONTENT).build();
	}
		
}
