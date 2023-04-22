package org.edu.unidep.domain.exception.manytomany;

public class AlunoNaoEncontradoException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public AlunoNaoEncontradoException(Long id) {
		super(String.format("Aluno de id %d não existe!", id));
	}

}
