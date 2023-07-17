package org.edu.unidep.api.rest;

import java.time.LocalDate;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
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

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.parameters.Parameter;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;
import org.edu.unidep.api.assembler.ProdutoOutputAssembler;
import org.edu.unidep.api.command.ProdutoCommand;
import org.edu.unidep.api.command.ProdutoQuery;
import org.edu.unidep.api.exceptionhandler.ExceptionMessage;
import org.edu.unidep.api.rest.request.ProdutoRequest;
import org.edu.unidep.api.rest.response.ProdutoResponse;
import org.edu.unidep.domain.model.Produto;
import org.edu.unidep.domain.service.ProdutoService;

@Path("/produtos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProdutoREST {

	@Inject
    private ProdutoService produtoService;
	
	@Inject
	private ProdutoOutputAssembler produtoOutputAssembler;
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(description = "Lista Todos Os Produtos")
    public List<ProdutoResponse> listarTodos() {
        return produtoOutputAssembler
        		.toCollectionResponse(produtoService.listar());
    }
    
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Operation(description = "Buscar Produto Por Id")
	@APIResponses({
		@APIResponse(responseCode = "200", description = "ok"),
		@APIResponse(responseCode = "404", description = "Produto Não Encontrado", content =
				@Content(schema = @Schema(implementation = ExceptionMessage.class)))		
	})
	public ProdutoResponse buscarProduto(
			@Parameter(description = "Id do Produto", example = "1", required = true)
			@PathParam("id") Long id) {		
		Produto produtoEncontrado = produtoService.acharOuFalhar(id);
		ProdutoResponse produtoResponse = produtoOutputAssembler.toResponse(produtoEncontrado);
		return produtoResponse;		
	}
	

    @GET
    @Path("/{id}/quantidade-total")
    @Produces(MediaType.APPLICATION_JSON)
    public Response retornarProdutoComQuantidadeTotal(
            @PathParam("id") Long codigoProduto) {

    	LocalDate dataInicio = LocalDate.parse("2023-04-15");
    	LocalDate dataFim = LocalDate.parse("2023-05-16");

        ProdutoQuery produtoQuery = produtoService.retornarProdutoComQuantidadeTotal(codigoProduto, dataInicio, dataFim);

        return Response.ok(produtoQuery).build();
    }

    @GET
    @Path("/{id}/quantidade-total-em-reais")
    @Produces(MediaType.APPLICATION_JSON)
    public Response retornarProdutoComQuantidadeTotalEmReais(
            @PathParam("id") Long codigoProduto
    ) {

    	LocalDate dataInicio = LocalDate.parse("2023-04-10");
    	LocalDate dataFim = LocalDate.parse("2023-05-16");
        ProdutoQuery produtoQuery = produtoService.retornarQuantidadeTotalEmReais(codigoProduto, dataInicio, dataFim);

        return Response.ok(produtoQuery).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
	@Operation(description = "Registra Um Produto")
	@APIResponses({
		@APIResponse(responseCode = "201", description = "Produto Registrado"),
		@APIResponse(responseCode = "400", description = "Requisição Não Atendida", content = 
			@Content(schema = @Schema(implementation = ExceptionMessage.class)))
	})
    public Response salvar(
    		@RequestBody(description = "Body", required = true)
    		ProdutoRequest request) {
    	produtoService.validarProdutoRequest(request);
        ProdutoCommand produtoCommand = ProdutoRequest.toCommand(request);
        produtoService.salvar(produtoCommand);
        return Response.status(Status.CREATED).build();
    }

	@PUT
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Operation(description = "Atualiza Um Produto")
	@APIResponses({
		@APIResponse(responseCode = "200", description = "Ok"),
		@APIResponse(responseCode = "400", description = "Requisição Não Atendida", content =
				@Content(schema = @Schema(implementation = ExceptionMessage.class))),
		@APIResponse(responseCode = "404", description = "Produto Não Encontrado", content =
			@Content(schema = @Schema(implementation = ExceptionMessage.class)))
	})
	public Response atualizar(
			@Parameter(description = "Id da Produto", example = "1", required = true)
			@PathParam("id") Long id,
			@RequestBody(description = "Body", required = true)
			ProdutoRequest request) {
		produtoService.validarProdutoRequest(request);
        ProdutoCommand produtoAtualizado =
                produtoService.atualizar(id, ProdutoRequest.toCommand(request));
		return Response.ok(produtoAtualizado).build();
	}
	
	@DELETE
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Operation(description = "Deletar Um Produto")
	@APIResponses({
		@APIResponse(responseCode = "204", description = "No Content"),
		@APIResponse(responseCode = "404", description = "Produto Não Encontrado", content =
			@Content(schema = @Schema(implementation = ExceptionMessage.class)))
	})
	public Response deletar(
			@Parameter(description = "Id da Produto", example = "1", required = true)
			@PathParam("id") Long id) {
		produtoService.deletarProduto(id);
		return Response.noContent().build();
	}
    
}
