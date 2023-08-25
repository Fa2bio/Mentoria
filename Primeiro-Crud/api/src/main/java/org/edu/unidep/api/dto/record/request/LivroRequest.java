package org.edu.unidep.api.dto.record.request;

import org.edu.unidep.api.dto.record.model.LivroModel;

import com.fasterxml.jackson.annotation.JsonProperty;

public record LivroRequest(
		
		@JsonProperty("isbn")
		String isbn
		) {

	public static LivroModel toModel(LivroRequest livroRequest) {
		return new LivroModel(livroRequest.isbn());
	}
}
