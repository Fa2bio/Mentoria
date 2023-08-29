package org.edu.unidep.api.dto.modelmapper.request;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ItemRequest {

	@NotNull
	@JsonProperty("quantidade")
	private Integer quantidade;
	
	@NotNull
	@JsonProperty("valorUnitario")
	private BigDecimal valorUnitario;
	
	@NotNull
	@JsonProperty("livroId")
	private Long livroId;
	
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
	public Long getLivroId() {
		return livroId;
	}
	public void setLivroId(Long livroId) {
		this.livroId = livroId;
	}
}
