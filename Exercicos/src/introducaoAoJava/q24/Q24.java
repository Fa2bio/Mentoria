package introducaoAoJava.q24;

import java.util.Scanner;

public class Q24 {

	public static void main(String[] args) {
		Scanner entrada=new Scanner(System.in);
		int numero;
		for(int i=0; i<10;i++);{
			
			System.out.println("Numero");
			numero=entrada.nextInt();
			
			if(numero==0) {
				System.out.println("zero");
			}
			else if (numero<0) {
				System.out.println("negativo");
			}
			else {
				System.out.println("positivo");
			}
			   
		}
		entrada.close();
	}
}
