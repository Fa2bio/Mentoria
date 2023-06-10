package org.edu.unidep.api.dto.response;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public record OrcamentoResponse(
		
		@JsonProperty("codigo_produto")
		Long id,
		
		@JsonProperty("data")
		LocalDate data,
		
		@JsonProperty("data_validade")
		LocalDate dataValidade,
		
		@JsonProperty("valor")
		BigDecimal valor,
		
		@JsonProperty("itens")
		List<ItemResponse> itens		
		) {

}
