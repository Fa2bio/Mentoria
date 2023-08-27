package org.edu.unidep.api.dto.record.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.edu.unidep.api.dto.record.model.FuncionarioModel;
import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonProperty;

public record FuncionarioRequest(
		
		@JsonProperty("nome")
		@NotNull
		@NotBlank
		String nome,
		
		@JsonProperty("cpf")
		@NotNull
		@NotBlank
		@CPF
		String cpf,
		
		@JsonProperty("cep")
		@NotNull
		@NotBlank
		@Size(min = 8, max = 9)
		String cep
		) {

	public static FuncionarioModel toModel(FuncionarioRequest funcionarioRequest) {
		return new FuncionarioModel(funcionarioRequest.nome(), funcionarioRequest.cpf(), funcionarioRequest.cep());
	}
}
