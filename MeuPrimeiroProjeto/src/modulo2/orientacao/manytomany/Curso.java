package modulo2.orientacao.manytomany;

import java.util.ArrayList;
import java.util.List;

public class Curso {
	String nome;
	
	List<Aluno> alunos = new ArrayList<>();
	
	public void adicionarAluno(Aluno aluno) {
		this.alunos.add(aluno);
		aluno.cursos.add(this);
	}
	
	public Curso(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}
	
	
}
