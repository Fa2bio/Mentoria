package org.edu.unidep.api.dto.request;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ClienteIdRequest(
		@JsonProperty("codigo_cliente")
		@NotNull
		Long id
		) {
}
