package org.edu.unidep.api.dto.record.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public record LivroModel(
		@JsonProperty("isbn")
		String isbn		
		) {

}
