package org.edu.unidep.api.dto.modelmapper.request;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ItemRequest {

	@NotNull(message = "Quantidade Do Item Não Pode Ser Nulo")
	@JsonProperty("quantidade")
	@Schema(description = "Quantidade", example = "3")
	private Integer quantidade;
	
	@NotNull(message = "Valor Unitario Do Item Não Pode Ser Nulo")
	@JsonProperty("valorUnitario")
	@Schema(description = "Valor Unitario", example = "39.49")
	private BigDecimal valorUnitario;
	
	@NotNull(message = "Id Do Livro Não Pode Ser Nulo")
	@JsonProperty("livroId")
	@Schema(description = "Id Do Livro", example = "1")
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
