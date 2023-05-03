package org.edu.unidep.api.rest.response;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;

public record PessoaResponse(
		
		@JsonProperty("codigo_pessoa")
		Long id, 
		
		@JsonProperty("nome")
		String nome,
		
		@JsonProperty("data_aniversario")
		LocalDate dataAniversario, 
		
		@JsonProperty("tipo_sanguineo")
		String tipoSanguineo, 
		
		@JsonProperty("endereco")
		String endereco, 
		
		@JsonProperty("cpf")
		String cpf){
}
