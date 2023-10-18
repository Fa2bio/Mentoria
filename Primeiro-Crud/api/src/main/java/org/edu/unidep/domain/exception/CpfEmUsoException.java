package org.edu.unidep.domain.exception;

public class CpfEmUsoException  extends EntidadeEmUsoException{
	
	private static final long serialVersionUID = 1L;

	public CpfEmUsoException(String cpf) {
		super(String.format("O CPF %s não pode ser usado, pois já existe um cadastro.", cpf));
	}
}
