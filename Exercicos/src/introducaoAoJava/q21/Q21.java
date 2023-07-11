package introducaoAoJava.q21;

import java.util.Scanner;

public class Q21 {
	public static void main(String[] args) {
		int n;
		
		Scanner entrada = new Scanner(System.in);
		System.out.print("Digite o tamanho do array: ");
		n = entrada.nextInt();
		
		int[] array = new int[n];
		
		int tamanho = array.length;
		
		System.out.println("Tamanho array" + tamanho);
		int acumulador = 0;
		for(int i = 0; i < tamanho;i++) {
			System.out.print("Digite a idade para a posição " + i +" :");
			array[i] = entrada.nextInt();
		}
		for(int i = 0; i < tamanho;i++) {
			if(array[i] >= 18) {
				acumulador = acumulador +1;
			}
		}
		
		System.out.println("A quantidade de pessoas aptas ao servico militar eh de: " + acumulador);
		
		entrada.close();
	}
}
