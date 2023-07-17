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
import org.edu.unidep.api.dto.assembler.manytomany.AlunoInputDisassembler;
import org.edu.unidep.api.dto.assembler.manytomany.AlunoOutAssembler;
import org.edu.unidep.api.dto.model.manytomany.input.AlunoInputModel;
import org.edu.unidep.api.dto.model.manytomany.output.AlunoModel;
import org.edu.unidep.api.dto.model.manytomany.output.AlunoResumoModel;
import org.edu.unidep.domain.model.manytomany.Aluno;
import org.edu.unidep.domain.repository.manytomany.AlunoRepository;
import org.edu.unidep.domain.service.manytomany.AlunoService;

@Path("/alunos")
public class AlunoController {

	@Inject
	private AlunoRepository alunoRepository;
	
	@Inject
	private AlunoService alunoService;
	
	@Inject
	private AlunoOutAssembler alunoOutAssembler;
	
	@Inject
	private AlunoInputDisassembler alunoInputDisassembler;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<AlunoResumoModel> listarAlunos() {
		List<Aluno> todosAlunos = alunoRepository.listarAlunos();
		return alunoOutAssembler.toCollectionModel(todosAlunos);
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{id}")
	public AlunoModel buscarAlunoPorId(@PathParam("id") Long id) {
		Aluno aluno = alunoService.acharOuFalhar(id);
		return alunoOutAssembler.toModel(aluno);
	}
	
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response salvar(@RequestBody AlunoInputModel alunoInput) {
    	Aluno aluno = alunoInputDisassembler.toDomainObject(alunoInput);
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
