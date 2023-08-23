package org.edu.unidep.api.dto.model.onetomany.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public record CidadeRequest(
		@JsonProperty("nome")
		String nome,
		@JsonProperty("estadoId")
		EstadoIdRequest estadoId
		) {

	public static CidadeModel toModel(CidadeRequest cidadeRequest) {
		return new CidadeModel(
				cidadeRequest.nome,
				cidadeRequest.estadoId
				);
	}
}
