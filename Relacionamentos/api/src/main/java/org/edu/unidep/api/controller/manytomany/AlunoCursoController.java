package org.edu.unidep.api.controller.manytomany;

import javax.inject.Inject;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.edu.unidep.domain.service.manytomany.AlunoService;

@Path("/alunos/aluno/{alunoId}")
public class AlunoCursoController {
	
	@Inject
	private AlunoService alunoService;

	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/adicionar/curso/{cursoId}")
	public Response adicionarCurso(@PathParam("alunoId") Long alunoId,
			@PathParam("cursoId") Long cursoId) {
		alunoService.associarCurso(alunoId, cursoId);
		return Response.status(Status.NO_CONTENT).build();
	}
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/remover/curso/{cursoId}")
	public Response removerCurso(@PathParam("alunoId") Long alunoId,
			@PathParam("cursoId") Long cursoId) {
		alunoService.dissociarCurso(alunoId, cursoId);
		return Response.status(Status.NO_CONTENT).build();
	}
}
