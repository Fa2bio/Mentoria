package org.edu.unidep.domain.exception.onetoone;

public class CarroNaoEncontradoException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public CarroNaoEncontradoException(Long id) {
		super(String.format("Carro de id %d não existe!", id));
	}
}
