package org.edu.unidep.api.dto.record.request;

import org.edu.unidep.api.dto.record.model.FuncionarioModel;

import com.fasterxml.jackson.annotation.JsonProperty;

public record FuncionarioRequest(
		
		@JsonProperty("nome")
		String nome,
		
		@JsonProperty("cpf")
		String cpf,
		
		@JsonProperty("cep")
		String cep
		) {

	public static FuncionarioModel toModel(FuncionarioRequest funcionarioRequest) {
		return new FuncionarioModel(funcionarioRequest.nome(), funcionarioRequest.cpf(), funcionarioRequest.cep());
	}
}
