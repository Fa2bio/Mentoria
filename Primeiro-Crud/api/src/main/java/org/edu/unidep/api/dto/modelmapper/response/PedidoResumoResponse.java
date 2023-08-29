package org.edu.unidep.api.dto.modelmapper.response;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PedidoResumoResponse {

	@JsonProperty("codigoPedido")
	private String uuidCode;

	@JsonProperty("dataEmissao")
	private LocalDate dataEmissao;
	
	@JsonProperty("valor")
	private BigDecimal valor;
	
	@JsonProperty("itens")
	private List<ItemResumoResponse> itens;

	public String getUuidCode() {
		return uuidCode;
	}

	public void setUuidCode(String uuidCode) {
		this.uuidCode = uuidCode;
	}

	public LocalDate getDataEmissao() {
		return dataEmissao;
	}

	public void setDataEmissao(LocalDate dataEmissao) {
		this.dataEmissao = dataEmissao;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public List<ItemResumoResponse> getItens() {
		return itens;
	}

	public void setItens(List<ItemResumoResponse> itens) {
		this.itens = itens;
	}
	
}
