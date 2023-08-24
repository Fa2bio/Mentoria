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
import org.edu.unidep.domain.model.Funcionario;
import org.edu.unidep.domain.service.FuncionarioService;

@Path("/funcionarios")
public class FuncionarioController {

	@Inject
	private FuncionarioService funcionarioService;
	
	// Obtem dados do servidor
	@GET
	@Path("/listar")
	@Produces(MediaType.APPLICATION_JSON)
	public Response listarTodos() {
		List<Funcionario> funcionarios = funcionarioService.listarTodosFuncionarios();
		if(funcionarios.isEmpty()) return Response.status(Status.NO_CONTENT).build();
		return Response.ok(funcionarios).build();
	}
	
	@GET
	@Path("/buscar/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response buscarFuncionario(@PathParam("id") Long id) {
		Funcionario funcionario = funcionarioService.buscarOuFalhar(id);
		return Response.ok(funcionario).build();
	}
	
	// Altera dados de uma instancia presente no servidor
	@PUT	
	@Path("/atualizar/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response atualizarFuncionario(
			@PathParam("id") Long id,
			@RequestBody Funcionario funcionarioAtualizado) {
		funcionarioService.atualizarFuncionario(id, funcionarioAtualizado);
		return Response.status(Status.NO_CONTENT).build();
	}

	// Cria uma instancia no servidor
	@POST
	@Path("/registrar")
	@Produces(MediaType.APPLICATION_JSON)
	public Response registrar(@RequestBody Funcionario funcionario) {
		funcionarioService.salvarFuncionario(funcionario);
		return Response.status(Status.CREATED).build();
	}
	
	// Exclui uma instancia do servidor
	@DELETE
	@Path("/excluir/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response excluir(@PathParam("id") Long id) {
		funcionarioService.excluirFuncionario(id);
		return Response.status(Status.NO_CONTENT).build();
	}
}