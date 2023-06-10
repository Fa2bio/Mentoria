package org.edu.unidep.api.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ClienteResumoResponse(
		@JsonProperty("codigo_cliente")
	    Long id,
	    
	    @JsonProperty("nome")
	    String nome,
	    
	    @JsonProperty("email")
	    String email
		) {

}
