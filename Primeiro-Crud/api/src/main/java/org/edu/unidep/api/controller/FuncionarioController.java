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

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.parameters.Parameter;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.edu.unidep.api.dto.record.assembler.FuncionarioAssembler;
import org.edu.unidep.api.dto.record.model.FuncionarioModel;
import org.edu.unidep.api.dto.record.request.FuncionarioRequest;
import org.edu.unidep.api.exceptionhandler.ExceptionMessage;
import org.edu.unidep.domain.model.Funcionario;
import org.edu.unidep.domain.service.FuncionarioService;

@Path("/funcionarios")
@Tag(name = "Funcionario")
public class FuncionarioController {

	@Inject
	private FuncionarioService funcionarioService;
	
	@Inject
	private FuncionarioAssembler funcionarioAssembler;
	
	// Obtem dados do servidor
	@GET
	@Path("/listar")
	@Produces(MediaType.APPLICATION_JSON)
	@Operation(description = "Lista Todos Os Funcionarios")
	@APIResponses({
		@APIResponse(responseCode = "200", description = "Ok"),
		@APIResponse(responseCode = "204", description = "No Content")
	})
	public Response listarTodos() {
		List<Funcionario> funcionarios = funcionarioService.listarTodosFuncionarios();
		if(funcionarios.isEmpty()) return Response.status(Status.NO_CONTENT).build();
		return Response.ok(funcionarioAssembler.toCollectionResponse(funcionarios)).build();
	}
	
	@GET
	@Path("/buscar/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Operation(description = "Busca Funcionario Por Id")
	@APIResponses({
		@APIResponse(responseCode = "200", description = "Ok"),
		@APIResponse(responseCode = "404", description = "Funcionario Não Encontrado", content = 
				@Content(schema = @Schema(implementation = ExceptionMessage.class))
		)			
	})
	public Response buscarFuncionario(
			@Parameter(description = "Id do Funcionario", example = "1", required = true)
			@PathParam("id") Long id) {
		Funcionario funcionario = funcionarioService.buscarOuFalhar(id);
		return Response.ok(funcionarioAssembler.toResponse(funcionario)).build();
	}
	
	// Altera dados de uma instancia presente no servidor
	@PUT	
	@Path("/atualizar/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Operation(description = "Atualiza Funcionario Por Id")
	@APIResponses({
		@APIResponse(responseCode = "204", description = "Funcionario Atualizado"),
		@APIResponse(responseCode = "400", description = "Requisição Nao Entendida", content = 
		@Content(schema = @Schema(implementation = ExceptionMessage.class))),
		@APIResponse(responseCode = "404", description = "Funcionario Não Encontrado", content = 
				@Content(schema = @Schema(implementation = ExceptionMessage.class))
		)			
	})
	public Response atualizarFuncionario(			
			@Parameter(description = "Id do Funcionario", example = "1", required = true)
			@PathParam("id") Long id,
			
			@RequestBody(description = "body", required = true)
			FuncionarioRequest funcionarioAtualizado) {
		
		funcionarioService.validarFuncionarioRequest(funcionarioAtualizado);
		FuncionarioModel funcionarioModel = FuncionarioRequest.toModel(funcionarioAtualizado);
		funcionarioService.atualizarFuncionario(id, funcionarioModel);
		return Response.status(Status.NO_CONTENT).build();
	}

	// Cria uma instancia no servidor
	@POST
	@Path("/registrar")
	@Produces(MediaType.APPLICATION_JSON)
	@Operation(description = "Registra Um Funcionario")
	@APIResponses({
		@APIResponse(responseCode = "201", description = "Funcionario Registrado"),
		@APIResponse(responseCode = "400", description = "Requisição Nao Entendida", content = 
		@Content(schema = @Schema(implementation = ExceptionMessage.class)))			
	})
	public Response registrar(
			@RequestBody(description = "body", required = true)
			FuncionarioRequest funcionario) {
		
		funcionarioService.validarFuncionarioRequest(funcionario);
		FuncionarioModel funcionarioModel = FuncionarioRequest.toModel(funcionario);
		funcionarioService.salvarFuncionario(funcionarioModel);
		return Response.status(Status.CREATED).build();
	}
	
	// Exclui uma instancia do servidor
	@DELETE
	@Path("/excluir/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Operation(description = "Atualiza Funcionario Por Id")
	@APIResponses({
		@APIResponse(responseCode = "204", description = "Funcionario Deletado"),
		@APIResponse(responseCode = "404", description = "Funcionario Não Encontrado", content = 
				@Content(schema = @Schema(implementation = ExceptionMessage.class))
		)			
	})
	public Response excluir(
			@Parameter(description = "Id do Funcionario", example = "1", required = true)
			@PathParam("id") Long id) {
		funcionarioService.excluirFuncionario(id);
		return Response.status(Status.NO_CONTENT).build();
	}
}
