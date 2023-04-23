package org.edu.unidep.domain.exception.onetomany;

import org.edu.unidep.domain.exception.EntidadeNaoEncontradaException;

public class CidadeNaoEncontradoException extends EntidadeNaoEncontradaException{

	private static final long serialVersionUID = 1L;
	
	public CidadeNaoEncontradoException(Long id) {
		super(String.format("Cidade de id %d não existe!", id));
	}
}
