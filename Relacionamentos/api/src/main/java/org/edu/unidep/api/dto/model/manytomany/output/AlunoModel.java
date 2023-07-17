package org.edu.unidep.api.dto.model.manytomany.output;

import java.util.ArrayList;
import java.util.List;

public class AlunoModel {

	private Long id;
	private String nome;
	private List<CursoResumoModel> cursos = new ArrayList<>();
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
	public List<CursoResumoModel> getCursos() {
		return cursos;
	}
	public void setCursos(List<CursoResumoModel> cursos) {
		this.cursos = cursos;
	}
	
	
}
