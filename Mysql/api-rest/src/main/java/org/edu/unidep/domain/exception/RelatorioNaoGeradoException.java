package org.edu.unidep.domain.exception;

public class RelatorioNaoGeradoException extends EntidadeNaoEncontradaException{

	private static final long serialVersionUID = 1L;
	
	public RelatorioNaoGeradoException(Long codigoProduto) {
		super(String.format("Relatorio de vendas para o produto de código %d não pode ser gerado!", codigoProduto));
	}

}
