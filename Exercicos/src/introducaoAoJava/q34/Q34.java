package introducaoAoJava.q34;

import java.util.Scanner;

public class Q34 {

	public static void main(String[] args) {

		 Scanner entrada= new Scanner(System.in);
		 
		 int idade;
		 System.out.println("A idade é: ");
		 idade=entrada.nextInt();
		
		 if(idade <5 ) {
			 System.out.println("Idade inválida!");
		 }
		 else if(idade>=5 && idade<=7) {
			 System.out.println("O nadador pertence a categoria infatil A:");
		 }
		 else if(idade >=8 && idade<=10) {
			 System.out.println("O nadador pertence a categoria infantil B:");
		 }
		 else if(idade>=11 && idade <=13) {
			 System.out.println(" O nadador pertence a categoria juvenil A:");
		 }
		 else if(idade>=14 && idade <=17) {
			 System.out.println(" O nadador pertence a categoria juvenil B:"); 
		 }
		 else {
		 System.out.println(" O nadador pertence a categoria sênior"); 
			 
		 }
		 entrada.close();
		}
}
