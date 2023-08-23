package org.edu.unidep.api.dto.model.onetomany.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public record EstadoRequest(
		@JsonProperty("nome")
		String nome
		) {
	
	public static EstadoModel toModel(EstadoRequest estadoRequest) {
		return new EstadoModel(
				estadoRequest.nome
		);
	}
}
