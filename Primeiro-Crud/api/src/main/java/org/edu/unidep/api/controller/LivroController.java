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
import org.edu.unidep.api.dto.record.assembler.LivroAssembler;
import org.edu.unidep.api.dto.record.model.LivroModel;
import org.edu.unidep.api.dto.record.request.LivroRequest;
import org.edu.unidep.api.dto.record.response.LivroResponse;
import org.edu.unidep.api.exceptionhandler.ExceptionMessage;
import org.edu.unidep.domain.model.Livro;
import org.edu.unidep.domain.service.LivroService;

@Path("/livros")
@Tag(name = "Livro")
public class LivroController {

	@Inject
	private LivroService livroService;
	
	@Inject
	private LivroAssembler livroAssembler;
	
	// Obtem dados do servidor
	@GET
	@Path("/listar")
	@Produces(MediaType.APPLICATION_JSON)
	@Operation(description = "Listar Todos Os Livros")
	@APIResponses({
		@APIResponse(responseCode = "200", description = "Ok"),
		@APIResponse(responseCode = "204", description = "No Content")
		
	})
	public Response listarTodos(@Context UriInfo uriInfo) {
		List<Livro> livros = livroService.listarTodosLivros();
		if(livros.isEmpty()) return Response.status(Status.NO_CONTENT).build();
		List<LivroResponse> livrosResponse = livroAssembler.toCollectionResponse(livros, uriInfo);
		return Response.ok(livrosResponse).build();
	}
	
	@GET
	@Path("/buscar/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Operation(description = "Busca Um Livro Por Id")
	@APIResponses({
		@APIResponse(responseCode = "200", description = "Ok"),
		@APIResponse(responseCode = "404", description = "Livro Não Encontrado", content =
			@Content(schema = @Schema(implementation = ExceptionMessage.class))
		)
	})
	public Response buscarLivro(
			@Parameter(description = "Id do Livro", example = "1", required = true)
			@PathParam("id") Long id,
			@Context UriInfo uriInfo) {
		Livro livro = livroService.buscarOuFalhar(id);
		return Response.ok(livroAssembler.toResponse(livro, uriInfo)).build();
	}
	
	@GET
	@Path("/buscarporisbn/{isbn}")
	@Produces(MediaType.APPLICATION_JSON)
	@Operation(description = "Busca Um Livro Por Id")
	@APIResponses({
		@APIResponse(responseCode = "200", description = "Ok"),
		@APIResponse(responseCode = "404", description = "Livro Não Encontrado", content =
			@Content(schema = @Schema(implementation = ExceptionMessage.class))
		)
	})
	public Response buscarLivroPorIsbn(
			@Parameter(description = "Isbn do Livro", example = "8535914846", required = true)
			@PathParam("isbn") String isbn,
			@Context UriInfo uriInfo) {
		Livro livro = livroService.buscarPorIsbn(isbn);
		return Response.ok(livroAssembler.toResponse(livro, uriInfo)).build();
	}
	
	// Altera dados de uma instancia presente no servidor
	@PUT	
	@Path("/atualizar/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Operation(description = "Atualizar Um Livro Por Id")
	@APIResponses({
		@APIResponse(responseCode = "204", description = "Livro Atualizado"),
		@APIResponse(responseCode = "400", description = "Requisição Não Atendida", content =
		@Content(schema = @Schema(implementation = ExceptionMessage.class))
	),
		@APIResponse(responseCode = "404", description = "Livro Não Encontrado", content =
			@Content(schema = @Schema(implementation = ExceptionMessage.class))
		)
	})
	public Response atualizarLivro(
			@Parameter(description = "Id do Livro", example = "1", required = true)
			@PathParam("id") Long id,
			
			@RequestBody(description = "body", required = true)
			LivroRequest livroAtualizado) {
		
		livroService.validarLivroRequest(livroAtualizado);
		LivroModel livroModel = LivroRequest.toModel(livroAtualizado);
		livroService.atualizarLivro(id, livroModel);
		return Response.status(Status.NO_CONTENT).build();
	}

	// Cria uma instancia no servidor
	@POST
	@Path("/registrar")
	@Produces(MediaType.APPLICATION_JSON)
	@Operation(description = "Registra Um Livro")
	@APIResponses({
		@APIResponse(responseCode = "201", description = "Livro Registrado"),
		@APIResponse(responseCode = "400", description = "Requisição Não Atendida", content =
		@Content(schema = @Schema(implementation = ExceptionMessage.class))
		)
	})
	public Response registrar(
			@RequestBody(description = "body", required = true)
			LivroRequest livroRequest) {
		
		livroService.validarLivroRequest(livroRequest);
		LivroModel livroModel = LivroRequest.toModel(livroRequest);
		livroService.salvarLivro(livroModel);
		return Response.status(Status.CREATED).build();
	}
	
	// Exclui uma instancia do servidor
	@DELETE
	@Path("/excluir/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Operation(description = "Busca Um Livro Por Id")
	@APIResponses({
		@APIResponse(responseCode = "204", description = "Livro Excluido"),
		@APIResponse(responseCode = "404", description = "Livro Não Encontrado", content =
			@Content(schema = @Schema(implementation = ExceptionMessage.class))
		)
	})
	public Response excluir(
			@Parameter(description = "Id do Livro", example = "1", required = true)
			@PathParam("id") Long id) {
		livroService.excluirLivro(id);
		return Response.status(Status.NO_CONTENT).build();
	}
}
