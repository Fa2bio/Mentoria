package org.edu.unidep.domain.exception.onetomany;

public class CidadeNaoEncontradoException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public CidadeNaoEncontradoException(Long id) {
		super(String.format("Cidade de id %d não existe!", id));
	}
}
