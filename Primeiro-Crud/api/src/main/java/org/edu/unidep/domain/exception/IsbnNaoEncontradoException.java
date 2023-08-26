package org.edu.unidep.domain.exception;

public class IsbnNaoEncontradoException extends EntidadeNaoEncontradaException{

	private static final long serialVersionUID = 1L;

	public IsbnNaoEncontradoException(String message) {
		super(message);
	}
}
