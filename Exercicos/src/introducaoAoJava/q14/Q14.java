package introducaoAoJava.q14;

import java.util.Scanner;

public class Q14 {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		
		int n1; 
		int n2; 
		
		System.out.println("Digite o primeiro numero:");
		n1 = entrada.nextInt();
		System.out.println("Digite o segundo numero:");
		n2 = entrada.nextInt();
		
	    if(n1>n2) {
			System.out.println("O numero 1 é maior que o numero 2" );
	    					
	    }
	    else {
		    System.out.println("O numero 2 é maior que numero 1" ); }
	    
	    
	    entrada.close();
				
		}
}
