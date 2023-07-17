package introducaoAoJava.q15;

import java.util.Scanner;

public class Q15 {
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		int numero;
		System.out.print("Digite um numero inteiro: ");
		numero = entrada.nextInt();
		
		if(numero >= 100 && numero <= 200) {
			System.out.println("Numero esta entre 100 e 200");
		}else if(numero < 100) {
			System.out.println("Numero eh menor que 100");
		}else {
			System.out.println("Numero eh maior que 200");
		}
		
		entrada.close();
	}
}
