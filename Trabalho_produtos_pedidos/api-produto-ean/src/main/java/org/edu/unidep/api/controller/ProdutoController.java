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
	private ProdutoAssembler produtoOutputAssembler;
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response listarTodos() {
    	List<Produto> produtos = produtoService.listar();
    	if(produtos.isEmpty()) return Response.status(Status.NO_CONTENT).build();
        return Response.ok(produtoOutputAssembler.toCollectionResponse(produtos)).build();
    }
    
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public ProdutoResponse buscarProduto(
			@PathParam("id") Long id) {		
		Produto produtoEncontrado = produtoService.buscarPorCodigo(id);
		ProdutoResponse produtoResponse = produtoOutputAssembler.toResponse(produtoEncontrado);
		return produtoResponse;		
	}

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response salvar(@RequestBody @Valid ProdutoRequest produtoInput) {
        ProdutoModel produtoModel = ProdutoRequest.toModel(produtoInput);
        produtoService.salvar(produtoModel);
        return Response.status(Status.CREATED).build();
    }

	@PUT
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response atualizar(@PathParam("id") Long id, @RequestBody @Valid ProdutoRequest produtoInput) {
        Produto produtoAtualizado = produtoService.atualizar(id, ProdutoRequest.toModel(produtoInput));
        ProdutoResponse produtoResponse = produtoOutputAssembler.toResponse(produtoAtualizado);
		return Response.ok(produtoResponse).build();
	}
	
	@DELETE
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deletar(@PathParam("id") Long id) {
		produtoService.deletarProduto(id);
		return Response.noContent().build();
	}
    
}
