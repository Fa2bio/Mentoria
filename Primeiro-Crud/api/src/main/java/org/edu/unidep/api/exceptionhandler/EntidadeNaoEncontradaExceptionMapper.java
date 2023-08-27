package org.edu.unidep.api.exceptionhandler;

import java.time.LocalDateTime;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.edu.unidep.domain.exception.EntidadeNaoEncontradaException;

@Provider
public class EntidadeNaoEncontradaExceptionMapper implements ExceptionMapper<EntidadeNaoEncontradaException>{

	@Override
	public Response toResponse(EntidadeNaoEncontradaException exception) {
		ExceptionMessage error = new ExceptionMessage();
		error.setTimeStamp(LocalDateTime.now());
		error.setType(exception.getClass().getSimpleName());
		error.setUserMessage(exception.getMessage());
		return Response.status(Status.NOT_FOUND).entity(error).build();
	}

}
