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
import org.edu.unidep.api.dto.record.assembler.LivroAssembler;
import org.edu.unidep.api.dto.record.model.LivroModel;
import org.edu.unidep.api.dto.record.request.LivroRequest;
import org.edu.unidep.api.dto.record.response.LivroResponse;
import org.edu.unidep.domain.model.Livro;
import org.edu.unidep.domain.service.LivroService;

@Path("/livros")
public class LivroController {

	@Inject
	private LivroService livroService;
	
	@Inject
	private LivroAssembler livroAssembler;
	
	// Obtem dados do servidor
	@GET
	@Path("/listar")
	@Produces(MediaType.APPLICATION_JSON)
	public Response listarTodos() {
		List<Livro> livros = livroService.listarTodosLivros();
		if(livros.isEmpty()) return Response.status(Status.NO_CONTENT).build();
		List<LivroResponse> livrosResponse = livroAssembler.toCollectionResponse(livros);
		return Response.ok(livrosResponse).build();
	}
	
	@GET
	@Path("/buscar/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response buscarLivro(@PathParam("id") Long id) {
		Livro livro = livroService.buscarOuFalhar(id);
		return Response.ok(livroAssembler.toResponse(livro)).build();
	}
	
	// Altera dados de uma instancia presente no servidor
	@PUT	
	@Path("/atualizar/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response atualizarLivro(
			@PathParam("id") Long id,
			@RequestBody LivroRequest livroAtualizado) {
		
		livroService.validarLivroRequest(livroAtualizado);
		LivroModel livroModel = LivroRequest.toModel(livroAtualizado);
		livroService.atualizarLivro(id, livroModel);
		return Response.status(Status.NO_CONTENT).build();
	}

	// Cria uma instancia no servidor
	@POST
	@Path("/registrar")
	@Produces(MediaType.APPLICATION_JSON)
	public Response registrar(@RequestBody LivroRequest livroRequest) {
		
		livroService.validarLivroRequest(livroRequest);
		LivroModel livroModel = LivroRequest.toModel(livroRequest);
		livroService.salvarLivro(livroModel);
		return Response.status(Status.CREATED).build();
	}
	
	// Exclui uma instancia do servidor
	@DELETE
	@Path("/excluir/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response excluir(@PathParam("id") Long id) {
		livroService.excluirLivro(id);
		return Response.status(Status.NO_CONTENT).build();
	}
}
