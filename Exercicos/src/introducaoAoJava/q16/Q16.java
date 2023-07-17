package introducaoAoJava.q16;

import java.util.Scanner;

public class Q16 {

	public static void main(String[] args) {
		Scanner entrada = new Scanner (System.in);
		String nome;	
		float nota1;
		float nota2;
		float nota3;

		System.out.println("Digite o nome do aluno: ");
		nome = entrada.next();
		System.out.println("Digite a primeira nota: ");
		nota1 = entrada.nextFloat();
		System.out.println("Digite a segunda  nota: ");
		nota2 = entrada.nextFloat();
		System.out.println("Digite a terceira nota: ");
		nota3 = entrada.nextFloat();
		double media = (nota1 + nota2 + nota3)/3;
 
		if (media>=7.0) {
			System.out.println("aprovado:");
		}else if (media > 5.1 && media < 6.9) {
		 System.out.println("recuperação: ");
		}else {
		 System.out.println("Reprovado: ");
		} 
	 
		System.out.println("A media do aluno é: " + media);
		media = entrada.nextFloat();
		entrada.close();
	}
}
