package introducaoAoJava.q18;

import java.util.Scanner;

public class Q18 {

	public static void main(String[] args) {
		
		int[] array = new int[3];
		
		Scanner entrada=new Scanner(System.in);
		
		int tamanho = array.length;
		
		
		
		for(int i= 0; i <tamanho;i++) {
			System.out.println("Digite uma idade para a posição" +i + ":");
			array[i] = entrada.nextInt();
		}
		
			for(int i= 0; i <tamanho;i++) {
			System.out.println(array[i]);	
			
			if(array[i]>=18) {
				System.out.println("maior idade: ");
				
			}
			else {
				System.out.println("menor idade: ");
				
			}
		}
		
		entrada.close();
		
	}
}
