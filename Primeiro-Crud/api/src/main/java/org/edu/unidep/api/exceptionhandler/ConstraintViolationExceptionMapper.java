package org.edu.unidep.api.exceptionhandler;

import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class ConstraintViolationExceptionMapper implements ExceptionMapper<ConstraintViolationException>{

	@Override
	public Response toResponse(ConstraintViolationException exception) {
		Set<ExceptionMessage.FieldError> fieldsErrors = new LinkedHashSet<>();
		
		for(ConstraintViolation<?> erro : exception.getConstraintViolations()) {
			ExceptionMessage.FieldError error = new ExceptionMessage
					.FieldError(erro.getPropertyPath().toString(),
							erro.getMessage());
			
			fieldsErrors.add(error);
		}
		
		ExceptionMessage exceptionResponse = new ExceptionMessage();
		exceptionResponse.setTimeStamp(LocalDateTime.now());	
		exceptionResponse.setType(exception.getClass().getSimpleName());
		exceptionResponse.setUserMessage("As seguintes propriedades possuem valores inválidos");
		exceptionResponse.setFieldErrors(fieldsErrors);
	
		return Response.status(Status.BAD_REQUEST).entity(exceptionResponse).build();
	}

}
