package org.edu.unidep.api.dto.modelmapper.model;

import java.util.ArrayList;
import java.util.List;

public class VolumeInfoModel {

	private String titulo;

	private String dataPublicacao;

	private String descricao;

	private String lingua;

	private Long qtdPags;

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

