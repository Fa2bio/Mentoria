package org.edu.unidep.api.dto.record.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public record EnderecoResponse(
		
		@JsonProperty("cep")
		String cep,
		
		@JsonProperty("bairro")
		String bairro,
		
		@JsonProperty("localidade")
		String localidade,
		
		@JsonProperty("logradouro")
		String logradouro,
		
		@JsonProperty("complemento")
		String complemento		
		) {

}
