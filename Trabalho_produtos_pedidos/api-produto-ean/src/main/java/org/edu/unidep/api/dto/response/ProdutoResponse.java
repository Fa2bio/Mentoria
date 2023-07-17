package org.edu.unidep.api.dto.response;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ProdutoResponse(
		
		@JsonProperty("codigo_produto")
		Long id,
		
		@JsonProperty("nome")
		String nome,
		
		@JsonProperty("categoria")
		String categoria, 
		
		@JsonProperty("codigo_ean")
		String codigoEan,
		
		@JsonProperty("data_validade")
		LocalDate dataValidade		
		) {
}
