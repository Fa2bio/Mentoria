package introducaoAoJava.q17;

import java.util.Scanner;

public class Q17 {
	public static void main(String[] args) {
		int[] array = new int[5];
		Scanner entrada = new Scanner(System.in);
		int tamanho = array.length;
		for(int i = 0; i < tamanho;i++) {
			System.out.print("Digite um numero inteiro para a posicao " + i +" :");
			array[i] = entrada.nextInt();
		}
		int acumulador = 0;
		for(int i = 0; i < tamanho;i++) {
			if(array[i] >= 10 && array[i] <=150) {
				acumulador = acumulador +1;
			}
		}
		
		System.out.println("A quantidade de numeros entre 10 e 150 eh: " + acumulador);
		
		entrada.close();
	}
}
