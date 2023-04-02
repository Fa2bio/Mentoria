package avancado.manytomany;

import java.util.ArrayList;
import java.util.List;

public class Curso {
	String nome;
	List<Aluno> alunos = new ArrayList<>();
	
	public Curso(String nome) {
		this.nome = nome;
	}
	
	void adicionar(Aluno aluno) {
		this.alunos.add(aluno);
		aluno.cursos.add(this);
	}
}
