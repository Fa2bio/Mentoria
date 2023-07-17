package org.edu.unidep.api.dto.response;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ItemResponse(
		
		@JsonProperty("codigo_item")
		Long id,
		
		@JsonProperty("quantidade")
		Integer quantidade,
		
		@JsonProperty("valor_total")
		BigDecimal valorTotal,
		
		@JsonProperty("valor_unitario")
		BigDecimal valorUnitario,
		
		@JsonProperty("produto")
		ProdutoResponse produto
		
		) {

}
