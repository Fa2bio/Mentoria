package org.edu.unidep.domain.exception;

public class FuncionarioNaoEncontradoException extends EntidadeNaoEncontradaException{

	private static final long serialVersionUID = 1L;

	public FuncionarioNaoEncontradoException(Long id) {
		super(String.format("Não foi possível encontrar o funcionario de id %d", id));
	}

}
