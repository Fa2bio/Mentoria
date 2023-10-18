package org.edu.unidep.api.dto.modelmapper.response;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ItemResumoResponse {

	@JsonProperty("quantidade")
	private Integer quantidade;
	
	@JsonProperty("valorTotal")
	private BigDecimal valorTotal;
	
	@JsonProperty("valorUnitario")
	private BigDecimal valorUnitario;
	
	@JsonProperty("livro")
	private LivroResumoResponse livro;
	
	public Integer getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	public BigDecimal getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}
	public BigDecimal getValorUnitario() {
		return valorUnitario;
	}
	public void setValorUnitario(BigDecimal valorUnitario) {
		this.valorUnitario = valorUnitario;
	}
	public LivroResumoResponse getLivro() {
		return livro;
	}
	public void setLivro(LivroResumoResponse livro) {
		this.livro = livro;
	}
}
