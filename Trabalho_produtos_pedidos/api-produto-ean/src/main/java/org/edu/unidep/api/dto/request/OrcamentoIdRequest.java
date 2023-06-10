package org.edu.unidep.api.dto.request;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

public record OrcamentoIdRequest(
		@JsonProperty("codigo_orcamento")
		@NotNull
		Long id
		) {

}
