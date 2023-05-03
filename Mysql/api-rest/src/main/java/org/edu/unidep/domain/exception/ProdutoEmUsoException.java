package org.edu.unidep.domain.exception;

public class ProdutoEmUsoException extends EntidadeEmUsoException{
	
	private static final long serialVersionUID = 1L;
	
	public ProdutoEmUsoException(Long id) {
		super(String.format("O Produto de id: %d, não pode ser excluído pois esta em uso!",id));
	}	
}
