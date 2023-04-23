package org.edu.unidep.domain.exception.manytomany;

import org.edu.unidep.domain.exception.EntidadeNaoEncontradaException;

public class AlunoNaoEncontradoException extends EntidadeNaoEncontradaException{

	private static final long serialVersionUID = 1L;
	
	public AlunoNaoEncontradoException(Long id) {
		super(String.format("Aluno de id %d não existe!", id));
	}

}
