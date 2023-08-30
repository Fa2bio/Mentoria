package org.edu.unidep.api.dto.record.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.edu.unidep.api.dto.record.model.FuncionarioModel;
import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonProperty;

public record FuncionarioRequest(
		
		@JsonProperty("nome")
		@NotNull(message = "Nome Do Funcionario Não Pode Ser Nulo")
		@NotBlank(message = "Nome Do Funcionario Não Pode Estar Em Branco")
		@Schema(description = "Nome Do Funcionario", example = "Roberto")
		String nome,
		
		@JsonProperty("cpf")
		@NotNull(message = "CPF Do Funcionario Não Pode Ser Nulo")
		@NotBlank(message = "CPF Do Funcionario Não Pode Estar Em Branco")
		@CPF(message = "O CPF Informado Deve Ser Válido De Acordo Com As Normas Da Receita Federal Brasileira")
		@Schema(description = "CPF Do Funcionario", example = "961.464.370-69")
		String cpf,
		
		@JsonProperty("cep")
		@NotNull(message = "CEP Do Funcionario Não Pode Ser Nulo")
		@NotBlank(message = "CEP Do Funcionario Não Pode Estar Em Branco")
		@Size(min = 8, max = 9, message = "O CEP Deve Possuir 8 ou 9 Caracteres")
		@Schema(description = "CEP Do Funcionario", example = "20251-901")
		String cep
		) {

	public static FuncionarioModel toModel(FuncionarioRequest funcionarioRequest) {
		return new FuncionarioModel(funcionarioRequest.nome(), funcionarioRequest.cpf(), funcionarioRequest.cep());
	}
}
