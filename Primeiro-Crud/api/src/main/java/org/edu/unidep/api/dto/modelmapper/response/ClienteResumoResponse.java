package org.edu.unidep.api.dto.modelmapper.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ClienteResumoResponse {

	@JsonProperty("nome")
	private String nome;
	
	@JsonProperty("cpf")
	private String cpf;
	
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
}
