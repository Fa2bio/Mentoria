package org.edu.unidep.api.dto.record.response;

import java.util.List;

import javax.ws.rs.core.Link;

import com.fasterxml.jackson.annotation.JsonProperty;

public record LivroResponse(
		
		@JsonProperty("volumeInfo")
		VolumeInfoResponse volumeInfo,	
		
		@JsonProperty("cliente")
		ClienteResumoResponse cliente,
		
		@JsonProperty("links")
		List<Link> links
		) {

}
