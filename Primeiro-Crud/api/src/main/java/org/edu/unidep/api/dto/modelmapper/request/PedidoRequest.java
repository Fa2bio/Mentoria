package org.edu.unidep.api.dto.modelmapper.request;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PedidoRequest {

	@NotNull
	@JsonProperty("dataEmissao")
	private LocalDate dataEmissao;
	
	@NotNull
	@JsonProperty("clienteId")
	private Long clienteId;
	
	@NotNull
	@JsonProperty("funcionarioId")
	private Long funcionarioId;
	
	@NotNull
	@Valid
	@JsonProperty("itens")
	private List<ItemRequest> itens;

	public LocalDate getDataEmissao() {
		return dataEmissao;
	}

	public void setDataEmissao(LocalDate dataEmissao) {
		this.dataEmissao = dataEmissao;
	}

	public Long getClienteId() {
		return clienteId;
	}

	public void setClienteId(Long clienteId) {
		this.clienteId = clienteId;
	}

	public Long getFuncionarioId() {
		return funcionarioId;
	}

	public void setFuncionarioId(Long funcionarioId) {
		this.funcionarioId = funcionarioId;
	}

	public List<ItemRequest> getItens() {
		return itens;
	}

	public void setItens(List<ItemRequest> itens) {
		this.itens = itens;
	}

}
