package org.edu.unidep.domain.exception;

public class ClienteNaoEncontradoException extends EntidadeNaoEncontradaException{
	
	private static final long serialVersionUID = 1L;
	
	public ClienteNaoEncontradoException(Long id) {
		super(String.format("Não foi possível encontrar o cliente de id %d", id));
	}
}
