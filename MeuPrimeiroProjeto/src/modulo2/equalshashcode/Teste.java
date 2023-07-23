package modulo2.equalshashcode;

public class Teste {

	public static void main(String[] args) {
		Aluno a1 = new Aluno("Fabio","Correa");
		Aluno a2 = new Aluno("Fabio","Correa");
		
		System.out.println(a1);
		System.out.println(a2);
		
		System.out.println(a1.equals(a2));
		System.out.println(a1.hashCode());
		System.out.println(a2.hashCode());
		
	}
}
