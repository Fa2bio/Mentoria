package introducaoAoJava.q13;

import java.util.Scanner;

public class Q13 {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		int numero;
		System.out.print("Digite um numero inteiro: ");
		numero = entrada.nextInt();
		if(numero > 10) {
			System.out.println("Este numero é maior que 10");
		}else if(numero == 10) {
			System.out.println("Este numero é igual à 10");
		}else {
			System.out.println("Este numero é menor que 10");
		}
		entrada.close();
	}
}
