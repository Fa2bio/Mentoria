package org.edu.unidep.domain.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Endereco {

	@Column(name = "endereco_cep", length = 10, nullable = false)
	private String cep;
	
	@Column(name = "endereco_bairro", length = 255, nullable = false)
	private String bairro;
	
	@Column(name = "endereco_localidade", length = 255, nullable = false)
	private String localidade;
	
	@Column(name = "endereco_logradouro", length = 255, nullable = false)
	private String logradouro;
	
	@Column(name = "endereco_complemento", length = 255, nullable = false)
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
