package org.edu.unidep.api.dto.modelmapper.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EnderecoResponse {

	@JsonProperty("cep")
	private String cep;
	
	@JsonProperty("bairro")
	private String bairro;
	
	@JsonProperty("localidade")
	private String localidade;
	
	@JsonProperty("logradouro")
	private String logradouro;

	@JsonProperty("complemento")
	private String complemento;

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getLocalidade() {
		return localidade;
	}

	public void setLocalidade(String localidade) {
		this.localidade = localidade;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

}
