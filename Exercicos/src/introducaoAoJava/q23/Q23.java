package introducaoAoJava.q23;

import java.util.Scanner;

public class Q23 {

	public static void main(String[] args) {
		Scanner entrada= new Scanner(System.in);
		
		int numero;
		
		System.out.println("Digite um numero: ");
		numero=entrada.nextInt();
		
		if(numero>80 ) {
			System.out.println("Número maior que 80");
			}
				
		else if (numero<25 || numero == 40) {
			System.out.println("Número menor que 25 OU igual a 40");								
		}


		entrada.close();
	}
}
