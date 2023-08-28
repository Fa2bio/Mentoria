package org.edu.unidep.domain.exception;

public class PedidoNaoEncontradoException extends EntidadeNaoEncontradaException{

	private static final long serialVersionUID = 1L;
	
	public PedidoNaoEncontradoException(Long id) {
		super(String.format("Pedido de id: %d não encotrado", id));
	}
	
	public PedidoNaoEncontradoException(String codigo) {
		super(String.format("Pedido de codigo: %s não encotrado", codigo));
	}

}
