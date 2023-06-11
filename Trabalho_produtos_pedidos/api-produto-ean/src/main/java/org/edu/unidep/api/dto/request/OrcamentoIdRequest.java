package org.edu.unidep.api.dto.request;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

public record OrcamentoIdRequest(
		
		@NotNull
		@JsonProperty("codigo_orcamento")
		Long id
		) {

}
