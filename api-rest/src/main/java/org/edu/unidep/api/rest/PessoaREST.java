package org.edu.unidep.api.rest;

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
import org.edu.unidep.api.assembler.PessoaOutputAssembler;
import org.edu.unidep.api.command.PessoaCommand;
import org.edu.unidep.api.exceptionhandler.ExceptionMessage;
import org.edu.unidep.api.rest.request.PessoaRequest;
import org.edu.unidep.api.rest.response.PessoaResponse;
import org.edu.unidep.domain.model.Pessoa;
import org.edu.unidep.domain.service.PessoaService;

@Path("/pessoas")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PessoaREST {

	@Inject
    private PessoaService pessoaService;
	
	@Inject
	private PessoaOutputAssembler pessoaOutputAssembler;
    
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Operation(description = "Lista Todas As Pessoas")
	public List<PessoaResponse> listarPessoas() {	
		return pessoaOutputAssembler
				.toCollectionResponse(pessoaService.listar());
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Operation(description = "Busca Pessoa Por Id")
	@APIResponses({
		@APIResponse(responseCode = "404", description = "Pessoa Não Encontrada", content = 
			@Content(schema = @Schema(implementation = ExceptionMessage.class)))
	})
	public PessoaResponse buscarPessoaPorId(
			@Parameter(description = "Id da Pessoa", example = "1", required = true)
			@PathParam("id") Long id) {
		Pessoa pessoaEncontrada = pessoaService.acharOuFalhar(id);
		PessoaResponse pessoaResponse = pessoaOutputAssembler.toResponse(pessoaEncontrada);
		return pessoaResponse;
	}

    @POST
    @Produces(MediaType.APPLICATION_JSON)
	@Operation(description = "Registra Uma Pessoa")
	@APIResponses({
		@APIResponse(responseCode = "201", description = "Pessoa Registrada"),
		@APIResponse(responseCode = "400", description = "Requisição Não Atendida", content = 
			@Content(schema = @Schema(implementation = ExceptionMessage.class)))
	})
    public Response salvar(
    		@RequestBody(description = "Body", required = true)
    		PessoaRequest request) {
    	pessoaService.validarPessoaRequest(request);
        PessoaCommand pessoaCommand = PessoaRequest.toCommand(request);
        pessoaService.salvar(pessoaCommand);
        return Response.status(Status.CREATED).build();
    }

    @PUT
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
	@Operation(description = "Atualiza Um Registro De Pessoa Por Id")
	@APIResponses({
		@APIResponse(responseCode = "200", description = "Pessoa Atualizada"),
		@APIResponse(responseCode = "400", description = "Requisição Não Atendida", content = 
			@Content(schema = @Schema(implementation = ExceptionMessage.class))),
		@APIResponse(responseCode = "404", description = "Pessoa Não Encontrada")
	})
    public Response atualizar(
    		@Parameter(description = "Id da Pessoa", example = "1", required = true)
            @PathParam("id") Long id,
            @RequestBody(description = "Body", required = true) 
            PessoaRequest request){
    	pessoaService.validarPessoaRequest(request);
        PessoaCommand pessoaAtualizada =
                pessoaService.atualizar(id, PessoaRequest.toCommand(request));

        return Response.ok(pessoaAtualizada).build();
    }
    
	@DELETE
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Operation(description = "Deleta Um Registro De Pessoa Por Id")
	@APIResponses({
		@APIResponse(responseCode = "204", description = "Pessoa Excluída"),
		@APIResponse(responseCode = "404", description = "Pessoa Não Encontrada")
	})
	public Response deletar(
			@Parameter(description = "Id da Pessoa", example = "1", required = true)
			@PathParam("id") Long id) {
		pessoaService.deletarPessoa(id);
		return Response.noContent().build();
	}

}
