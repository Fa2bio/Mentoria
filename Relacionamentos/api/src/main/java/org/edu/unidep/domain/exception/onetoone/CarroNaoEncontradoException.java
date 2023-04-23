package org.edu.unidep.domain.exception.onetoone;

import org.edu.unidep.domain.exception.EntidadeNaoEncontradaException;

public class CarroNaoEncontradoException extends EntidadeNaoEncontradaException{

	private static final long serialVersionUID = 1L;
	
	public CarroNaoEncontradoException(Long id) {
		super(String.format("Carro de id %d não existe!", id));
	}
}
