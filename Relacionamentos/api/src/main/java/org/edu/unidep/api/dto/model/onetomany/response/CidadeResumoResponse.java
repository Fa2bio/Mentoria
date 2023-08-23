package org.edu.unidep.api.dto.model.onetomany.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public record CidadeResumoResponse(		
		@JsonProperty("id")
		Long id,
		@JsonProperty("nome")
		String nome
		) {

}
