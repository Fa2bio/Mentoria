package modulo2.orientacao;

public class TesteAlunoCurso {
	public static void main(String[] args) {
		Aluno a1 = new Aluno("Fabio");
		Aluno a2 = new Aluno("Carla");
		
		Curso c1 = new Curso("Ciencia da computação");
		Curso c2 = new Curso("Sistemas de informação");
		
		a1.adicionarCurso(c1);
		a1.adicionarCurso(c2);
		
		c1.adicionarAluno(a2);
		
		for (Curso c : a1.cursos) {
			System.out.println(c.getNome());
		}
		
		for (Aluno a : c1.alunos) {
			System.out.println(a.getNome());
		}
	}
}
