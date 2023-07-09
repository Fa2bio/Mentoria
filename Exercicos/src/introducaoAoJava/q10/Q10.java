package introducaoAoJava.q10;

import java.util.Scanner;

public class Q10 {
	public static void main(String[] args) {
		double valorCompra;
		double valorPrestacao;
		int numeroPrestacao = 5;
		
		Scanner entrada = new Scanner(System.in);
		System.out.print("Digite o valor da Compra: ");
		valorCompra = entrada.nextDouble();
		
		entrada.close();
		
		valorPrestacao = calcularPrestacao(valorCompra, numeroPrestacao);
		System.out.println("O valor das prestações eh: " + valorPrestacao);
				
	}
	
	private static double calcularPrestacao(double valorCompra, double numeroPrestacao) {
		return valorCompra/numeroPrestacao;
	}
}
