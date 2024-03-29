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
import org.edu.unidep.api.dto.assembler.onetomany.CidadeAssembler;
import org.edu.unidep.api.dto.model.onetomany.request.CidadeRequest;
import org.edu.unidep.domain.model.onetomany.Cidade;
import org.edu.unidep.domain.repository.onetomany.CidadeRepository;
import org.edu.unidep.domain.service.onetomany.CidadeService;

@Path("/cidades")
public class CidadeController {

	@Inject
	private CidadeRepository cidadeRepository;
	
	@Inject
	private CidadeService cidadeService;
	
	@Inject
	private CidadeAssembler cidadeAssembler;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response listarCidades() {
		List<Cidade> todasCidades = cidadeRepository.listarCidades();
		return Response.ok(cidadeAssembler.toCollectionResponse(todasCidades)).build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{id}")
	public Response buscarCidadePorId(@PathParam("id") Long id) {
		Cidade cidade = cidadeService.acharOuFalhar(id);
		return Response.ok(cidadeAssembler.toResponse(cidade)).build();
	}
	
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response salvar(@RequestBody CidadeRequest cidadeRequest) {
    	cidadeService.registrar(CidadeRequest.toModel(cidadeRequest));
    	return Response.status(Status.CREATED).build();
    }
    
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Response excluir(@PathParam("id") Long id) {
    	cidadeService.excluirCidade(id);
    	return Response.noContent().build();
    }
}
