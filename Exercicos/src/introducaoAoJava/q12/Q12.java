package introducaoAoJava.q12;

import java.util.Scanner;

public class Q12 {

	public static void main(String[] args) {
		double valorCarro;
		
		double percentualDistribuidor = 28.0/100.0;
		double percentualImpostos = 45.0/100.0;
		
		Scanner entrada = new Scanner(System.in);
		System.out.print("Digite o valor do carro: ");
		valorCarro = entrada.nextDouble();
		
		double valorCarroAposPercentualDistribuidor = valorCarro + calcularPorcentagemDistribuidor(valorCarro, percentualDistribuidor);
		
		double valorVenda = valorCarroAposPercentualDistribuidor + calcularPorcentagemImpostos(valorCarroAposPercentualDistribuidor, percentualImpostos);
		
		System.out.println("O valor de venda do carro eh de " + valorVenda);
		
		entrada.close();
	}
	
	public static double calcularPorcentagemDistribuidor(double valorCarro, double percentualDistribuidor) {
		double valor = valorCarro * percentualDistribuidor;
		return valor;
	}
	
	public static double calcularPorcentagemImpostos(double valorCarroAposPercentualDistribuidor, double percentualImpostos) {
		double valor = valorCarroAposPercentualDistribuidor * percentualImpostos;
		return valor;
	}
}
