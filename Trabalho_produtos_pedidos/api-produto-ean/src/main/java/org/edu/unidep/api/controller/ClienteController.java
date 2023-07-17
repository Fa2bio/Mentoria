package org.edu.unidep.api.controller;

import java.util.List;

import javax.inject.Inject;
import javax.validation.Valid;
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
import org.edu.unidep.api.dto.assembler.ClienteAssembler;
import org.edu.unidep.api.dto.model.ClienteModel;
import org.edu.unidep.api.dto.request.ClienteRequest;
import org.edu.unidep.api.dto.response.ClienteResponse;
import org.edu.unidep.api.dto.response.ClienteResumoResponse;
import org.edu.unidep.domain.model.Cliente;
import org.edu.unidep.domain.service.ClienteService;

@Path("/clientes")
public class ClienteController {

	@Inject
	private ClienteService clienteService;
	
	@Inject
	private ClienteAssembler clienteAssembler;
	
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response listarTodos() {
    	List<Cliente> clientes = clienteService.listar();
    	if(clientes.isEmpty()) return Response.status(Status.NO_CONTENT).build();
        return Response.ok(clienteAssembler.toCollectionResumoResponse(clientes)).build();
    }
    
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public ClienteResponse buscarCliente(
			@PathParam("id") Long id) {		
		Cliente clienteEncontrado = clienteService.buscarPorCodigo(id);
		ClienteResponse clienteResponse = clienteAssembler.toResponse(clienteEncontrado);
		return clienteResponse;		
	}
	
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response salvar(@RequestBody @Valid ClienteRequest clienteInput) {
    	ClienteModel clienteModel = ClienteRequest.toModel(clienteInput);
    	clienteService.salvar(clienteModel);
        return Response.status(Status.CREATED).build();
    }
    
	@PUT
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response atualizar(@PathParam("id") Long id, @RequestBody @Valid ClienteRequest clienteInput) {
		Cliente clienteAtualizado = clienteService.atualizar(id, ClienteRequest.toModel(clienteInput));
		ClienteResumoResponse clienteResponse = clienteAssembler.toResumoResponse(clienteAtualizado);
		return Response.ok(clienteResponse).build();
	}
    
	@DELETE
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deletar(@PathParam("id") Long id) {
		clienteService.deletarCliente(id);
		return Response.noContent().build();
	}
}
