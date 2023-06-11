package org.edu.unidep.api.dto.request;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.edu.unidep.api.dto.model.ProdutoModel;
import org.hibernate.validator.constraints.EAN;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ProdutoRequest(
		
		@NotNull
		@NotBlank
		@Size(min = 1, max = 100)
		@JsonProperty("nome")
		String nome,
		
		@NotNull
		@NotBlank
		@Size(min = 1, max = 100)
		@JsonProperty("categoria")
		String categoria,
		
		@NotNull
		@EAN
		@JsonProperty("codigo_ean")
		String codigoEan,
		
		@NotNull
		@JsonProperty("data_validade")
		LocalDate dataValidade
		) {
	
	public static ProdutoModel toModel(ProdutoRequest produtoRequest) {
		return new ProdutoModel(
				produtoRequest.nome,
				produtoRequest.categoria,
				produtoRequest.codigoEan,
				produtoRequest.dataValidade
				);
	}

}
