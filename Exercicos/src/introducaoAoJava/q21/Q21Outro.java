package introducaoAoJava.q21;

import java.util.Scanner;

public class Q21Outro {
	public static void main(String[] args) {
		int n;
		Scanner entrada = new Scanner(System.in);
		System.out.print("Digite a quantidade de pessoas: ");
		n = entrada.nextInt();
		int acumulador = 0;
		for(int i = 0; i<n;i++) {
			String nome;
			String sexo;
			int idade;
			String saude;
			
			System.out.print("Digite nome: ");
			nome = entrada.next();
			
			System.out.print("Digite idade: ");
			idade = entrada.nextInt();
			
			System.out.print("Digite sexo M para masculino e F para feminino: ");
			sexo = entrada.next();
			
			System.out.print("Digite saude: ");
			saude = entrada.next();
			
			if(sexo.equalsIgnoreCase("M") && idade>=18) {
				System.out.println("O " + nome + "esta apto");
				acumulador = acumulador + 1;
			}
		}
		
		System.out.println("A qtd de pessoas aptas é de: " + acumulador);
		
		entrada.close();
	}
}
