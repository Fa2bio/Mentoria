package org.edu.unidep.api.controller.onetomany;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.edu.unidep.api.dto.assembler.onetomany.EstadoAssembler;
import org.edu.unidep.api.dto.model.onetomany.request.EstadoRequest;
import org.edu.unidep.domain.model.onetomany.Estado;
import org.edu.unidep.domain.repository.onetomany.EstadoRepository;
import org.edu.unidep.domain.service.onetomany.EstadoService;

@Path("/estados")
public class EstadoController {

	@Inject
	private EstadoRepository estadoRepository;
	
	@Inject
	private EstadoService estadoService;
	
	@Inject
	private EstadoAssembler estadoAssembler;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response listarEstados() {
		List<Estado> todosEstados = estadoRepository.listarEstados();
		return Response.ok(estadoAssembler.toCollectionResponse(todosEstados)).build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Response buscarPorId(@PathParam("id") Long id) {
		Estado estado = estadoService.acharOuFalhar(id);
		return Response.ok(estadoAssembler.toResponse(estado)).build();
	}
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response salvar(@RequestBody EstadoRequest estadoRequest) {
    	estadoService.registrar(EstadoRequest.toModel(estadoRequest));
    	return Response.status(Status.CREATED).build();
    }
    
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Response excluir(@PathParam("id") Long id) {
		estadoService.excluirEstado(id);
		return Response.noContent().build();	
    }
}
