package introducaoAoJava.q20;

import java.util.Scanner;

public class Q20 {
	public static void main(String[] args) {
		double valorCarro;
		int anoCarro;
		double valorDesconto;
		double valorPago;
		double descontoAte2000 = 12.0/100.0;
		double descontoAcima2000 = 7.0/100.0;
		String caracter;
		
		Scanner entrada = new Scanner(System.in);
		
		do {
			
			System.out.print("Digite o valor do carro: ");
			valorCarro = entrada.nextDouble();
			
			System.out.print("Digite o ano do carro: ");
			anoCarro = entrada.nextInt();
			
			if(anoCarro <= 2000) {
				valorDesconto = calcularDescontoAte2000(valorCarro, descontoAte2000);
				valorPago = valorCarro - valorDesconto;
				System.out.println("O valor do desconto eh de " + valorDesconto);
				System.out.println("O valor pago eh de " + valorPago);
			}else {
				valorDesconto = calcularDescontoAcima2000(valorCarro, descontoAcima2000);
				valorPago = valorCarro - valorDesconto;
				System.out.println("O valor do desconto eh de " + valorDesconto);
				System.out.println("O valor pago eh de " + valorPago);
			}
			
			System.out.print("Digite N para sair: ");
			caracter = entrada.next();
		}while(!caracter.equalsIgnoreCase("N"));
		entrada.close();		
	}
	
	public static double calcularDescontoAte2000(double valorCarro, double descontoAte2000) {
		double desconto = valorCarro * descontoAte2000;
		return desconto;
	}
	
	public static double calcularDescontoAcima2000(double valorCarro, double descontoAcima2000) {
		double desconto = valorCarro * descontoAcima2000;
		return desconto;
	}
}
