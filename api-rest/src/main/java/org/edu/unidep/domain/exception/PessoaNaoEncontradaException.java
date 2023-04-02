package org.edu.unidep.domain.exception;

public class PessoaNaoEncontradaException extends NegocioException{

	private static final long serialVersionUID = 1L;
	
	public PessoaNaoEncontradaException(Long id) {
		super(String.format("Pessoa de Id %d não existe!", id));
	}

}
