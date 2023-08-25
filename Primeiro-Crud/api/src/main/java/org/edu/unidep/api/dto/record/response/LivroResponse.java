package org.edu.unidep.api.dto.record.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public record LivroResponse(
		
		@JsonProperty("isbn")
		String isbn,
		
		@JsonProperty("volumeInfo")
		VolumeInfoResponse volumeInfo,	
		
		@JsonProperty("cliente")
		ClienteResumoResponse cliente
		) {

}
