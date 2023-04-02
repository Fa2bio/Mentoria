package org.edu.unidep.api.rest;

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
import org.edu.unidep.domain.model.Pessoa;
import org.edu.unidep.domain.model.PessoaViaCep;
import org.edu.unidep.domain.repository.PessoaRepository;
import org.edu.unidep.domain.service.PessoaService;

@Path("/pessoa")
public class PessoaRest {

	@Inject
	private PessoaRepository pessoaRepository;
	
	@Inject
	private PessoaService pessoaService;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response listarPessoas() {
		List<Pessoa> todosPessoas = pessoaRepository.listarPessoas();
		return Response.ok(todosPessoas).build();
	}
	
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listarPessoasPeloCodigo(
            @PathParam("id") Long id) {
        Pessoa pessoaEncontrado = pessoaService.acharOuFalhar(id);  		

        return Response.ok(pessoaEncontrado).build();
    }
    
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response salvar(@RequestBody Pessoa Pessoa) {
    	pessoaService.registrar(Pessoa);
    	return Response.status(Status.CREATED).build();
    }
    
    @PUT
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response atualizar(
            @PathParam("id") Long id,
            @RequestBody Pessoa Pessoa) {

        Pessoa pessoaAtualizada =
        		pessoaService.atualizar(id, Pessoa);

        return Response.ok(pessoaAtualizada).build();
    }
    
    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deletar(@PathParam("id") Long id) {
    	pessoaService.deletarPessoa(id);
    	return Response.noContent().build();
    }
    
    @POST
    @Path("/viacep")
    @Produces(MediaType.APPLICATION_JSON)
    public Response registrar(@RequestBody PessoaViaCep pessoa) {
    	
    	Pessoa p = pessoaService.viaCep(pessoa, pessoa.getCep());
    	pessoaService.registrar(p);
    	return Response.status(Status.CREATED).build();
    }
}
