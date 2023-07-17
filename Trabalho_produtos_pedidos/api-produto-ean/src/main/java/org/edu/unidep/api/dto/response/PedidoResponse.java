package org.edu.unidep.api.dto.response;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;

public record PedidoResponse(
		
		@JsonProperty("codigo_pedido")
		Long id,
		
		@JsonProperty("data_emissao")
		LocalDate data,
		
		@JsonProperty("orcamento")
		OrcamentoResponse orcamento,
		
		@JsonProperty("cliente")
		ClienteResumoResponse cliente		
		) {

}
