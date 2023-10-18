package org.edu.unidep.domain.exception;

public class ClienteEmUsoException extends EntidadeEmUsoException{

	private static final long serialVersionUID = 1L;
	
	public ClienteEmUsoException(Long id) {
		super(String.format("O cliente de id %d não pode ser excluido, pois esta em uso", id));
	}

}
