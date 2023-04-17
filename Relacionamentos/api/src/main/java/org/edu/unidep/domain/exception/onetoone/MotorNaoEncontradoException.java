package org.edu.unidep.domain.exception.onetoone;

public class MotorNaoEncontradoException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public MotorNaoEncontradoException(Long id) {
		super(String.format("Motor de id %d não existe!", id));
	}

}
