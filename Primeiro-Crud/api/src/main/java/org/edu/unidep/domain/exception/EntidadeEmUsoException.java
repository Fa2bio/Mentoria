package org.edu.unidep.domain.exception;

public abstract class EntidadeEmUsoException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public EntidadeEmUsoException(String message) {
		super(message);
	}
}
