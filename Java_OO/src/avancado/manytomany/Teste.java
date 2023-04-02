package avancado.manytomany;

public class Teste {
	public static void main(String[] args) {
		Curso c1 = new Curso("Ciencia da computacao");
		Curso c2 = new Curso("Sistemas");
		Aluno a1 = new Aluno("Fabio");
		Aluno a2 = new Aluno("Carla");
		
		a1.adicionar(c1);
		c2.adicionar(a1);
		c2.adicionar(a2);
		
		System.out.println(a2.nome);
		for (Curso curso : a2.cursos) {
			System.out.println(curso.nome);
		}
		System.out.println();
		System.out.println(c2.nome);
		for (Aluno aluno : c2.alunos) {
			System.out.println(aluno.nome);
		}
	}
}
