package org.edu.unidep.domain.exception.onetomany;

import org.edu.unidep.domain.exception.EntidadeNaoEncontradaException;

public class EstadoNaoEncontradoException extends EntidadeNaoEncontradaException{

	private static final long serialVersionUID = 1L;
	
	public EstadoNaoEncontradoException(Long id) {
		super(String.format("Estado de id %d não existe!", id));
	}
}
