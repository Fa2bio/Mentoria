package org.edu.unidep.api.dto.modelmapper.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ClienteRequest {

	@JsonProperty("nome")
	@NotNull(message = "Nome Do Cliente Não Pode Ser Nulo")
	@NotBlank(message = "Nome Do Cliente Não Pode Estar Em Branco")
	@Schema(description = "Nome Do Cliente", example = "Fábio")
	private String nome;
	
	@JsonProperty("cpf")
	@NotNull(message = "CPF Do Cliente Não Pode Ser Nulo")
	@NotBlank(message = "CPF Do Cliente Não Pode Estar Em Branco")
	@CPF(message = "O CPF Informado Deve Ser Válido De Acordo Com As Normas Da Receita Federal Brasileira")
	@Schema(description = "CPF Do Cliente", example = "983.586.970-74")
	private String cpf;
	
	@JsonProperty("cep")
	@NotNull(message = "CEP Do Cliente Não Pode Ser Nulo")
	@NotBlank(message = "CEP Do Cliente Não Pode Estar Em Branco")
	@Size(min = 8, max = 9, message = "O CEP Deve Possuir 8 ou 9 Caracteres")
	@Schema(description = "CEP do Cliente", example = "20090-907")
	private String cep;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	
}
