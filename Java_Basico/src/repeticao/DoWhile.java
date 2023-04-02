package repeticao;

import java.util.Scanner;

public class DoWhile {

	public static void main(String[] args) {
		int a;
		int b;
		
		Scanner entrada = new Scanner(System.in);
		
		do{
			System.out.print("Digite o valor do primeiro numero: ");
			a = entrada.nextInt();
			System.out.print("Digite o valor do segundo numero: ");
			b = entrada.nextInt();
						
		}while(a < b);
		
	}
}
