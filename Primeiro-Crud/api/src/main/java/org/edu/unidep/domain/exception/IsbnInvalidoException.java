package org.edu.unidep.domain.exception;

public class IsbnInvalidoException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public IsbnInvalidoException(String message) {
		super(message);
	}
}
