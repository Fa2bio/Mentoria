package org.edu.unidep.api.controller;

import java.math.BigDecimal;
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
import org.edu.unidep.api.dto.assembler.OrcamentoAssembler;
import org.edu.unidep.api.dto.model.OrcamentoModel;
import org.edu.unidep.api.dto.request.OrcamentoRequest;
import org.edu.unidep.api.dto.response.OrcamentoResponse;
import org.edu.unidep.domain.model.Orcamento;
import org.edu.unidep.domain.service.OrcamentoService;

@Path("/orcamentos")
public class OrcamentoController {

	@Inject
	private OrcamentoService orcamentoService;
	
	@Inject
	private OrcamentoAssembler orcamentoAssembler;
	
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<OrcamentoResponse> listarTodos() {
        return orcamentoAssembler
        		.toCollectionResponse(orcamentoService.listar());
    }
    
	@GET
	@Path("/listarpeladata/{data}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<OrcamentoResponse> listarPelaData(
			@PathParam("data") String data) {
		LocalDate localDate = LocalDate.parse(data);
		return orcamentoAssembler
        		.toCollectionResponse(orcamentoService.buscarPelaData(localDate));	
	}
	
	@GET
	@Path("/listarpeladatavalidade/{data}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<OrcamentoResponse> listarPelaDataValidade(
			@PathParam("data") String data) {
		LocalDate localDate = LocalDate.parse(data);
		return orcamentoAssembler
        		.toCollectionResponse(orcamentoService.buscarPelaDataValidade(localDate));	
	}
	
	@GET
	@Path("/listarpelovalor/{valor}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<OrcamentoResponse> listarPeloValor(
			@PathParam("valor") BigDecimal valor) {
		return orcamentoAssembler
        		.toCollectionResponse(orcamentoService.buscarPeloValor(valor));	
	}
    
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public OrcamentoResponse buscarOrcamento(
			@PathParam("id") Long id) {		
		Orcamento orcamentoEncontrado = orcamentoService.buscarPorCodigo(id);
		OrcamentoResponse orcamentoResponse = orcamentoAssembler.toResponse(orcamentoEncontrado);
		return orcamentoResponse;		
	}
	
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response salvar(@RequestBody @Valid OrcamentoRequest orcamentoInput) {
    	OrcamentoModel orcamentoModel = OrcamentoRequest.toModel(orcamentoInput);
    	orcamentoService.salvar(orcamentoModel);
        return Response.status(Status.CREATED).build();
    }

}
