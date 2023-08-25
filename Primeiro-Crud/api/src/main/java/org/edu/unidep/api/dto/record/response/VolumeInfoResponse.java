package org.edu.unidep.api.dto.record.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public record VolumeInfoResponse(
		
		@JsonProperty("titulo")
		String titulo,
		
		@JsonProperty("dataPublicacao")
		String dataPublicacao,
		
		@JsonProperty("descricao")
		String descricao,
		
		@JsonProperty("lingua")
		String lingua,
		
		@JsonProperty("qtdPags")
		Long qtdPags,
		
		@JsonProperty("autores")
		List<String> autores
		) {
}
