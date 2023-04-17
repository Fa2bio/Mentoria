package org.edu.unidep.api.controller.onetoone;

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
import org.edu.unidep.domain.model.onetoone.Carro;
import org.edu.unidep.domain.repository.onetoone.CarroRepository;
import org.edu.unidep.domain.service.onetoone.CarroService;

@Path("/carros")
public class CarroController {

	@Inject
	private CarroRepository carroRepository;
	
	@Inject
	private CarroService carroService;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response listarCarrp(){
		List<Carro> carro = carroRepository.listarCarro();
		return Response.ok(carro).build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{id}")
	public Response buscarCarroPorId(@PathParam("id") Long id) {
		Carro carro = carroService.acharOuFalhar(id);
		return Response.ok(carro).build();
	}
	
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response salvar(@RequestBody Carro carro) {
    	carroService.registrar(carro);
    	return Response.status(Status.CREATED).build();
    }
    
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Response excluir(@PathParam("id") Long id) {
    	carroService.excluirCarro(id);
    	return Response.noContent().build();
    }
}
