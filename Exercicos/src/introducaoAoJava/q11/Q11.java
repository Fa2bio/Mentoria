package introducaoAoJava.q11;

import java.util.Scanner;

public class Q11 {
	public static void main(String[] args) {
		double valorProduto;
		double valorPorcentagem;
		double valorVenda;
		
		Scanner entrada = new Scanner(System.in);
		
		System.out.print("Digite o valor do produto: ");
		valorProduto = entrada.nextDouble();
		
		System.out.print("Digite o valor da porcentagem: ");
		valorPorcentagem = entrada.nextDouble();
		
		valorVenda = valorProduto + calcularPorcentagem(valorProduto, valorPorcentagem);
		
		System.out.println("O preco de venda eh: " + valorVenda);
		entrada.close();
	}
	
    private static double calcularPorcentagem(double valorProduto, double valorPorcentagem) {
    	double porcentagem;
    	double juroFixo = valorPorcentagem/100;
    	porcentagem = valorProduto * juroFixo;
    	return porcentagem;
    }
}
