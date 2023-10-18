package org.edu.unidep.api.dto.modelmapper.response;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class VolumeInfoResponse {

	@JsonProperty("titulo")
	private String titulo;

	@JsonProperty("dataPublicacao")
	private String dataPublicacao;

	@JsonProperty("descricao")
	private String descricao;

	@JsonProperty("lingua")
	private String lingua;

	@JsonProperty("qtdPags")
	private Long qtdPags;

	@JsonProperty("autores")
	private List<String> autores = new ArrayList<>();

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDataPublicacao() {
		return dataPublicacao;
	}

	public void setDataPublicacao(String dataPublicacao) {
		this.dataPublicacao = dataPublicacao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getLingua() {
		return lingua;
	}

	public void setLingua(String lingua) {
		this.lingua = lingua;
	}

	public Long getQtdPags() {
		return qtdPags;
	}

	public void setQtdPags(Long qtdPags) {
		this.qtdPags = qtdPags;
	}

	public List<String> getAutores() {
		return autores;
	}

	public void setAutores(List<String> autores) {
		this.autores = autores;
	}

}

