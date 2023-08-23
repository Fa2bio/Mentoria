package org.edu.unidep.api.dto.model.onetomany.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public record EstadoResponse(		
		@JsonProperty("id")
		Long id,
		@JsonProperty("nome")
		String nome,
		@JsonProperty("cidades")
		List<CidadeResumoResponse> cidades
		) {

}
