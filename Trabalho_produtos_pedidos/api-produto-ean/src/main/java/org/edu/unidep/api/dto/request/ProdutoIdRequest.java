package org.edu.unidep.api.dto.request;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ProdutoIdRequest(
		
		@NotNull
		@JsonProperty("codigo_produto")
		Long id
		) {

}
