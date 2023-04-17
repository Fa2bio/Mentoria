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
import org.edu.unidep.domain.model.onetoone.Motor;
import org.edu.unidep.domain.repository.onetoone.MotorRepository;
import org.edu.unidep.domain.service.onetoone.MotorService;

@Path("/motores")
public class MotorControle {

	@Inject
	private MotorRepository motorRepository;
	
	@Inject
	private MotorService motorService;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response listarMotores(){
		List<Motor> motores = motorRepository.listarMotor();
		return Response.ok(motores).build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{id}")
	public Response buscarMotorPorId(@PathParam("id") Long id) {
		Motor motor = motorService.acharOuFalhar(id);
		return Response.ok(motor).build();
	}
	
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response salvar(@RequestBody Motor motor) {
    	motorService.registrar(motor);
    	return Response.status(Status.CREATED).build();
    }
    
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Response excluir(@PathParam("id") Long id) {
    	motorService.excluirMotor(id);
    	return Response.noContent().build();
    }
}
