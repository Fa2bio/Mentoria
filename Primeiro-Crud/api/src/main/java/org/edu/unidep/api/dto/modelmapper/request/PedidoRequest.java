package org.edu.unidep.api.dto.modelmapper.request;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PedidoRequest {

	@NotNull(message = "Data da Emissão Não Pode Ser Nula")
	@JsonProperty("dataEmissao")
	@Schema(description = "Data Da Emissão", example = "2023-08-30")
	private LocalDate dataEmissao;
	
	@NotNull(message = "Id Do Cliente Não Pode Ser Nulo")
	@JsonProperty("clienteId")
	@Schema(description = "Id Do Cliente", example = "1")
	private Long clienteId;
	
	@NotNull(message = "Id Do Funcionario Não Pode Ser Nulo")
	@JsonProperty("funcionarioId")
	@Schema(description = "Id Do Funcionario", example = "1")
	private Long funcionarioId;
	
	@NotNull(message = "Os Itens Não Podem Ser Nulos")
	@Valid
	@JsonProperty("itens")
	@Schema(description = "Lista De Itens")
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
