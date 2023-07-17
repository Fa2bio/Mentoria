package introducaoAoJava.q26;

import java.util.Scanner;

public class Q26 {

	public static void main(String[] args) {
		Scanner entrada= new Scanner(System.in);
		
		int numero;
		System.out.println("Qual o numero? ");
		numero=entrada.nextInt();
		
		switch(numero){
		
			case 1:System.out.println("um");break;
			case 2:System.out.println("dois");break;
			case 3:System.out.println("tres");break;
			case 4:System.out.println("quatro");break;
			case 5:System.out.println("cinco");break;
			default: System.out.println("número invalido");break;
		}

		entrada.close();
	}
}
