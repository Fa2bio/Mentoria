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
	public Response listarTodos() {
		List<Orcamento> orcamentos = orcamentoService.listar();
		if(orcamentos.isEmpty()) return Response.status(Response.Status.NO_CONTENT).build();
		List<OrcamentoResponse> orcamentosResponse = orcamentoAssembler.toCollectionResponse(orcamentos);
		return Response.ok(orcamentosResponse).build();
	}
	
	@GET
	@Path("/listarpeladata/{data}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response listarPelaData(@PathParam("data") String data) {
		LocalDate localDate = LocalDate.parse(data);
		List<Orcamento> orcamentos = orcamentoService.buscarPelaData(localDate);
		if(orcamentos.isEmpty()) return Response.status(Response.Status.NO_CONTENT).build();
		List<OrcamentoResponse> orcamentosResponse = orcamentoAssembler.toCollectionResponse(orcamentos);
		return Response.ok(orcamentosResponse).build();
	}
	
	@GET
	@Path("/listarpeladatavalidade/{data}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response listarPelaDataValidade(@PathParam("data") String data) {
		LocalDate localDate = LocalDate.parse(data);
		List<Orcamento> orcamentos = orcamentoService.buscarPelaDataValidade(localDate);
		if(orcamentos.isEmpty()) return Response.status(Response.Status.NO_CONTENT).build();
		List<OrcamentoResponse> orcamentosResponse = orcamentoAssembler.toCollectionResponse(orcamentos);
		return Response.ok(orcamentosResponse).build();
	}	
	
	@GET
	@Path("/listarpelovalor/{valor}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response listarPorMaiorValor(@PathParam("valor") BigDecimal valor) {
		List<Orcamento> orcamentos = orcamentoService.buscarPeloValor(valor);
		if(orcamentos.isEmpty()) return Response.status(Response.Status.NO_CONTENT).build();
		List<OrcamentoResponse> orcamentosResponse = orcamentoAssembler.toCollectionResponse(orcamentos);
		return Response.ok(orcamentosResponse).build();
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response buscarPeloCodigo(@PathParam("id") Long id) {
		Orcamento orcamentoEncontrado = orcamentoService.buscarPeloCodigo(id);
		OrcamentoResponse orcamentoResponse = orcamentoAssembler.toResponse(orcamentoEncontrado);
		return Response.ok(orcamentoResponse).build();
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response criar(@RequestBody @Valid OrcamentoRequest orcamentoRequest) {
		OrcamentoModel orcamentoModel = OrcamentoRequest.toModel(orcamentoRequest);
		orcamentoService.criar(orcamentoModel);
		return Response.status(Status.CREATED).build();
	}
}
