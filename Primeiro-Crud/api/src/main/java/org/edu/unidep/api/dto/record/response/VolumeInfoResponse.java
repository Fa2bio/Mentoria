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
		
		@JsonProperty("isbn10")
		String isbn10,
		
		@JsonProperty("isbn13")
		String isbn13,
		
		@JsonProperty("autores")
		List<String> autores
		) {
}
