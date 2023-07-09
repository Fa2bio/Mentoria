package introducaoAoJava.q5;

import java.util.Scanner;

public class Q5 {
	public static void main(String[] args) {
		double nota1;
		double nota2;
		double nota3;
		
		Scanner entrada = new Scanner(System.in);
		System.out.print("Digite a primeira nota: ");
		nota1 = entrada.nextDouble();
		System.out.print("Digite a segunda nota: ");
		nota2 = entrada.nextDouble();
		System.out.print("Digite a terceira nota: ");
		nota3 = entrada.nextDouble();
		
		System.out.println("A media do Aluno eh: " + calcularMedia(nota1,nota2,nota3));
		entrada.close();
	}
	
	private static double calcularMedia(double nota1, double nota2, double nota3) {
		return (nota1 + nota2 + nota3)/3;
	}
}
