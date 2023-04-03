package modulo2.orientacao.manytomany;

import java.util.ArrayList;
import java.util.List;

public class Aluno {
	String nome;
	List<Curso> cursos = new ArrayList<>();
	
	public void adicionarCurso(Curso c) {
		this.cursos.add(c);
		c.alunos.add(this);
	}
	
	public Aluno(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}
	
	
}
