package org.edu.unidep.api.dto.modelmapper.response;

import java.math.BigDecimal;

public class ItemResumoResponse {

	private Integer quantidade;
	private BigDecimal valorTotal;
	private BigDecimal valorUnitario;
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
