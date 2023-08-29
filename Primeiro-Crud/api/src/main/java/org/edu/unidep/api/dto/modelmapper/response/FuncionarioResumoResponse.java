package org.edu.unidep.api.dto.modelmapper.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FuncionarioResumoResponse {
	
	@JsonProperty("nome")
	private String nome;

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

}
