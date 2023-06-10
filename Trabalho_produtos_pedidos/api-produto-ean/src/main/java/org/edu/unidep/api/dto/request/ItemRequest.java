package org.edu.unidep.api.dto.request;

import java.math.BigDecimal;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ItemRequest(
		
		@JsonProperty("quantidade")
		@NotNull
		Integer quantidade,
		
		@JsonProperty("valor_unitario")
		@NotNull
		BigDecimal valorUnitario,
		
		@JsonProperty("produto")
		@NotNull
		@Valid
		ProdutoIdRequest produto
		) {

}
