package org.edu.unidep.api.dto.record.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ClienteResumoResponse(
		
		@JsonProperty("nome")
		String nome,
		
		@JsonProperty("cpf")
		String cpf		
		) {

}
