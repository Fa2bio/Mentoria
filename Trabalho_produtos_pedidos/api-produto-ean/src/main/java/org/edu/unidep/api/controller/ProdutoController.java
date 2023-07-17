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
import org.edu.unidep.api.dto.assembler.ProdutoAssembler;
import org.edu.unidep.api.dto.model.ProdutoModel;
import org.edu.unidep.api.dto.request.ProdutoRequest;
import org.edu.unidep.api.dto.response.ProdutoResponse;
import org.edu.unidep.domain.model.Produto;
import org.edu.unidep.domain.service.ProdutoService;


@Path("/produtos")
public class ProdutoController {

	@Inject
	private ProdutoService produtoService;
	
	@Inject
	private ProdutoAssembler produtoAssembler;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response listarTodos() {
		List<Produto> produtos = produtoService.listar();
		if(produtos.isEmpty()) return Response.status(Response.Status.NO_CONTENT).build();
		List<ProdutoResponse> produtosResponse = produtoAssembler.toCollectionResponse(produtos);
		return Response.ok(produtosResponse).build();
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response buscarPorId(@PathParam("id") Long id) {
		Produto produtoEncontrado = produtoService.buscarPorCodigo(id);
		ProdutoResponse produtoResponse = produtoAssembler.toResponse(produtoEncontrado);
		return Response.ok(produtoResponse).build();
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response criar(@RequestBody @Valid ProdutoRequest produtoRequest) {
		ProdutoModel produtoModel = ProdutoRequest.toModel(produtoRequest);
		produtoService.criar(produtoModel);
		return Response.status(Status.CREATED).build();
	}
	
	@PUT
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response atualizar(@PathParam("id") Long id, @RequestBody @Valid ProdutoRequest produtoRequest) {
		Produto produtoAtualizado = produtoService.atualizar(id, ProdutoRequest.toModel(produtoRequest));
		return Response.ok(produtoAtualizado).build();
	}
	
	@DELETE
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deletar(@PathParam("id") Long id) {
		produtoService.deletar(id);
		return Response.status(Status.NO_CONTENT).build();
	}
}
