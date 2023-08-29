package org.edu.unidep.api.dto.modelmapper.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ClienteRequest {

	@JsonProperty("nome")
	@NotNull
	@NotBlank
	private String nome;
	
	@JsonProperty("cpf")
	@NotNull
	@NotBlank
	@CPF
	private String cpf;
	
	@JsonProperty("cep")
	@NotNull
	@NotBlank
	@Size(min = 8, max = 9)
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
