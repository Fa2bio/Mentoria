package introducaoAoJava.q4;

import java.util.Scanner;

public class Q4 {
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		
		String nomeVendedor;
		double salarioFixo;
		double totalVendas;
		
		System.out.print("Digite o nome do vendedor: ");
		nomeVendedor = entrada.nextLine();
		System.out.print("Digite o salario do vendedor: ");
		salarioFixo = entrada.nextDouble();
		System.out.print("Digite o total de vendas do vendedor: ");
		totalVendas = entrada.nextDouble();
		
		System.out.println("O nome do vendedor eh: " + nomeVendedor);
		System.out.println("O salario do vendedor eh: " + salarioFixo);
		System.out.println("O salario no final do vendedor eh: " + calcularSalario(salarioFixo, totalVendas));
		
		entrada.close();
	}
	
	private static double calcularPorcentagem(double totalVendas) {
		double porcentagem;
		porcentagem = totalVendas * (15.0/100.0);
		return porcentagem;
	}
	
	private static double calcularSalario(double salarioFixo, double totalVendas) {
		double salarioTotal;
		salarioTotal = salarioFixo + calcularPorcentagem(totalVendas);
		return salarioTotal;
	}
	
}
