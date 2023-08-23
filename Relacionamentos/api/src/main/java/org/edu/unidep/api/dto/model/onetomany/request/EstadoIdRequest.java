package org.edu.unidep.api.dto.model.onetomany.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public record EstadoIdRequest(
		@JsonProperty("id")
		Long id
	) {

}
