package org.edu.unidep.api.dto.record.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.edu.unidep.api.dto.record.model.LivroModel;

import com.fasterxml.jackson.annotation.JsonProperty;

public record LivroRequest(
		
		@JsonProperty("isbn")
		@NotNull
		@NotBlank
		@Size(min = 10, max = 13)
		String isbn
		) {

	public static LivroModel toModel(LivroRequest livroRequest) {
		return new LivroModel(livroRequest.isbn());
	}
}
