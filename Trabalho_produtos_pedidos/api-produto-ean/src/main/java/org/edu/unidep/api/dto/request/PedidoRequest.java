package org.edu.unidep.api.dto.request;

import java.time.LocalDate;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.edu.unidep.api.dto.model.PedidoModel;

import com.fasterxml.jackson.annotation.JsonProperty;

public record PedidoRequest(
		
		@NotNull
		@JsonProperty("data_emissao")
		LocalDate data,
		
		@NotNull
		@Valid
		@JsonProperty("cliente")
		ClienteIdRequest cliente,
		
		@NotNull
		@Valid
		@JsonProperty("orcamento")
		OrcamentoIdRequest orcamento
		) {

	public static PedidoModel toModel(PedidoRequest pedidoRequest) {
		return new PedidoModel(
				pedidoRequest.data,
				pedidoRequest.cliente,
				pedidoRequest.orcamento
				);
	}
}
