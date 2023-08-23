package org.edu.unidep.api.dto.model.onetomany.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public record CidadeResponse(
		@JsonProperty("id")
		Long id,
		@JsonProperty("nome")
		String nome,
		@JsonProperty("estado")
		EstadoResumoResponse estado
		) {
}
