package org.edu.unidep.domain.exception;

public abstract class EntidadeInvalidaException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public EntidadeInvalidaException(String message) {
		super(message);
	}
}
