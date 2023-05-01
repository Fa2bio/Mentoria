package org.edu.unidep.api.rest.response;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ProdutoResponse(
		
		@JsonProperty("codigo_produto")
		Long id, 
		
		@JsonProperty("descricao")
		String descricao,
		
		@JsonProperty("unidade_medida")
		String unidadeMedida,
		
		@JsonProperty("data_vencimento")
		LocalDate dataVencimento){
}
