package avancado.manytomany;

import java.util.ArrayList;
import java.util.List;

public class Aluno {
	String nome;
	List<Curso> cursos = new ArrayList<>();
	
	public Aluno(String nome) {
		this.nome = nome;
	}
	
	public void adicionar(Curso curso) {
		this.cursos.add(curso);
		curso.alunos.add(this);
	}
}
