package org.edu.unidep.api.dto.request;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ProdutoIdRequest(
		@JsonProperty("codigo_produto")
		@NotNull
		Long id) {

}
