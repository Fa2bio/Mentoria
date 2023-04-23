package org.edu.unidep.domain.exception.manytomany;

import org.edu.unidep.domain.exception.EntidadeNaoEncontradaException;

public class CursoNaoEncontradoException extends EntidadeNaoEncontradaException{

	private static final long serialVersionUID = 1L;
	
	public CursoNaoEncontradoException(Long id) {
		super(String.format("Curso de id %d não existe!", id));
	}

}
