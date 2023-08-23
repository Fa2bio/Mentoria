package org.edu.unidep.domain.exception;

public class LivroNaoEncontradoException extends EntidadeNaoEncontradaException{

	private static final long serialVersionUID = 1L;

	public LivroNaoEncontradoException(Long id) {
		super(String.format("Não foi possível encontrar o livro de id %d", id));
	}

}
