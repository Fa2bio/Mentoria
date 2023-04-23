package org.edu.unidep.api.dto.model.manytomany.output;

import java.util.List;

public class CursoModel {

	private Long id;
	private String nome;
	private List<AlunoResumoModel> alunos;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public List<AlunoResumoModel> getAlunos() {
		return alunos;
	}
	public void setAlunos(List<AlunoResumoModel> alunos) {
		this.alunos = alunos;
	}
	
	
}
