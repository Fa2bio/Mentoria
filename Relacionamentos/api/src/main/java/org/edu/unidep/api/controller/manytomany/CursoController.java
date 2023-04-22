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
import org.edu.unidep.domain.model.manytomany.Curso;
import org.edu.unidep.domain.repository.manytomany.CursoRepository;
import org.edu.unidep.domain.service.manytomany.CursoService;

@Path("/cursos")
public class CursoController {

	@Inject
	private CursoRepository cursoRepository;
	
	@Inject
	private CursoService cursoService;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response listarCursos() {
		List<Curso> todosCursos = cursoRepository.listarCursos();
		return Response.ok(todosCursos).build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{id}")
	public Response buscarCursoPorId(@PathParam("id") Long id) {
		Curso curso = cursoService.acharOuFalhar(id);
		return Response.ok(curso).build();
	}
	
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response salvar(@RequestBody Curso curso) {
    	cursoService.registrar(curso);
    	return Response.status(Status.CREATED).build();
    }
    
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Response excluir(@PathParam("id") Long id) {
    	cursoService.excluirCurso(id);
    	return Response.noContent().build();
    }
}
