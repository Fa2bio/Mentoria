package org.edu.unidep.domain.exception.manytomany;

public class CursoNaoEncontradoException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public CursoNaoEncontradoException(Long id) {
		super(String.format("Curso de id %d não existe!", id));
	}

}
