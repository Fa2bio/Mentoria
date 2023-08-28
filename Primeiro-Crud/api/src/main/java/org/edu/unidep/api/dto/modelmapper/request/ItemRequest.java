package org.edu.unidep.api.dto.modelmapper.request;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;

public class ItemRequest {

	@NotNull
	private Integer quantidade;
	
	@NotNull
	private BigDecimal valorUnitario;
	
	@NotNull
	private Long livro_id;
	
	public Integer getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	public BigDecimal getValorUnitario() {
		return valorUnitario;
	}
	public void setValorUnitario(BigDecimal valorUnitario) {
		this.valorUnitario = valorUnitario;
	}
	public Long getLivro_id() {
		return livro_id;
	}
	public void setLivro_id(Long livro_id) {
		this.livro_id = livro_id;
	}
}
