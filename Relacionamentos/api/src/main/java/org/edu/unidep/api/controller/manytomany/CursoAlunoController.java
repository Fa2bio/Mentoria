package org.edu.unidep.api.controller.manytomany;

import javax.inject.Inject;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.edu.unidep.domain.service.manytomany.CursoService;

@Path("/cursos/curso/{cursoId}")
public class CursoAlunoController {

	@Inject
	private CursoService cursoService;
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/adicionar/aluno/{alunoId}")
	public Response adicionarCurso(@PathParam("cursoId") Long cursoId,
			@PathParam("alunoId") Long alunoId) {
		cursoService.associarAluno(cursoId, alunoId);
		return Response.status(Status.NO_CONTENT).build();
	}
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/remover/aluno/{alunoId}")
	public Response removerCurso(@PathParam("cursoId") Long cursoId,
			@PathParam("alunoId") Long alunoId) {
		cursoService.dissociarAluno(cursoId, alunoId);
		return Response.status(Status.NO_CONTENT).build();
	}
}
