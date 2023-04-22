package org.edu.unidep.api.controller.manytomany;

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
import org.edu.unidep.domain.model.manytomany.Aluno;
import org.edu.unidep.domain.repository.manytomany.AlunoRepository;
import org.edu.unidep.domain.service.manytomany.AlunoService;

@Path("/alunos")
public class AlunoController {

	@Inject
	private AlunoRepository alunoRepository;
	
	@Inject
	private AlunoService alunoService;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response listarAlunos() {
		List<Aluno> todosAlunos = alunoRepository.listarAlunos();
		return Response.ok(todosAlunos).build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{id}")
	public Response buscarAlunoPorId(@PathParam("id") Long id) {
		Aluno aluno = alunoService.acharOuFalhar(id);
		return Response.ok(aluno).build();
	}
	
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response salvar(@RequestBody Aluno aluno) {
    	alunoService.registrar(aluno);
    	return Response.status(Status.CREATED).build();
    }
    
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Response excluir(@PathParam("id") Long id) {
    	alunoService.excluirAluno(id);
    	return Response.noContent().build();
    }
}
