package org.edu.unidep.domain.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embeddable;

@Embeddable
public class VolumeInfo {

	@Column(name = "titulo", length = 255, nullable = false)
	private String titulo;
	
	@Column(name = "data_publicacao", length = 10, nullable = false)
	private String dataPublicacao;
	
	@Column(name = "descricao", length = 10000, nullable = false)
	private String descricao;
	
	@Column(name = "lingua", length = 255, nullable = false)
	private String lingua;
	
	@Column(name = "qtdPags", nullable = false)
	private Long qtdPags;
	
	@Column(name = "autores")
	@ElementCollection(targetClass = String.class)
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
