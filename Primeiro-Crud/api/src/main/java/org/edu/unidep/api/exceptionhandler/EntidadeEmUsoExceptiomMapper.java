package org.edu.unidep.api.exceptionhandler;

import java.time.LocalDateTime;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.edu.unidep.domain.exception.EntidadeEmUsoException;

@Provider
public class EntidadeEmUsoExceptiomMapper implements ExceptionMapper<EntidadeEmUsoException>{

	@Override
	public Response toResponse(EntidadeEmUsoException exception) {
		ExceptionMessage error = new ExceptionMessage();
		error.setTimeStamp(LocalDateTime.now());
		error.setType(exception.getClass().getSimpleName());
		error.setUserMessage(exception.getMessage());
		return Response.status(Status.BAD_REQUEST).entity(error).build();
	}

}
