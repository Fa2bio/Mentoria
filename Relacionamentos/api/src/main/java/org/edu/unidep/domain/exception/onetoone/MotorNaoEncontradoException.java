package org.edu.unidep.domain.exception.onetoone;

import org.edu.unidep.domain.exception.EntidadeNaoEncontradaException;

public class MotorNaoEncontradoException extends EntidadeNaoEncontradaException{

	private static final long serialVersionUID = 1L;
	
	public MotorNaoEncontradoException(Long id) {
		super(String.format("Motor de id %d não existe!", id));
	}

}
