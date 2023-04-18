package org.edu.unidep.domain.exception.onetomany;

public class EstadoNaoEncontradoException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public EstadoNaoEncontradoException(Long id) {
		super(String.format("Estado de id %d não existe!", id));
	}
}
