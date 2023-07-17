package org.edu.unidep.api.dto.request;

import java.math.BigDecimal;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ItemRequest(
		
		@NotNull
		@JsonProperty("quantidade")
		Integer quantidade,
		
		@NotNull
		@JsonProperty("valor_unitario")
		BigDecimal valorUnitario,
		
		@NotNull
		@Valid
		@JsonProperty("produto")
		ProdutoIdRequest produto
		) {

}
