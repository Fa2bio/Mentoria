package org.edu.unidep.api.dto.record.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.edu.unidep.api.dto.record.model.LivroModel;

import com.fasterxml.jackson.annotation.JsonProperty;

public record LivroRequest(
		
		@JsonProperty("isbn")
		@NotNull(message = "Isbn Do Livro Não Pode Ser Nulo")
		@NotBlank(message = "Isbn Do Livro Não Pode Estar Em Branco")
		@Size(min = 10, max = 13, message = "O ISBN Deve Possuir 10 ou 13 Caracteres")
		@Schema(description = "Isbn Do Livro", example = "8535914846")
		String isbn
		) {

	public static LivroModel toModel(LivroRequest livroRequest) {
		return new LivroModel(livroRequest.isbn());
	}
}
