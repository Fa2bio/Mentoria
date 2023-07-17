package org.edu.unidep.domain.exception.onetoone;

import org.edu.unidep.domain.exception.EntidadeEmUsoException;

public class MotorEmUsoException extends EntidadeEmUsoException{

	private static final long serialVersionUID = 1L;
	
	public MotorEmUsoException(Long id) {
		super(String.format("O motor de id %d, não pode ser excluído pois esta em uso!"
				,id));	
	}

}
