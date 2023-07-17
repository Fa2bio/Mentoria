package introducaoAoJava.q27;

import java.util.Scanner;

public class Q27P2 {

	public static void main(String[] args) {

		double valorDesconto;
		double valorCarro;
		double valorPago;
		double DescontoAlcool=25.0/100.0;
		double DescontoGasolina=21.0/100.0;
		double DescontoDiesel=14.0/100.0;	
		String tipoCarro;
		
		Scanner entrada = new Scanner(System.in);
		
		do {

			System.out.println("Digite o valor do carro:");
		    valorCarro=entrada.nextDouble();
			System.out.println("Digite o tipo do carro: ");
			tipoCarro= entrada.nextLine();
	
			tipoCarro = entrada.next();

			if (tipoCarro.equalsIgnoreCase("Alcool")) {
				valorDesconto = calcularDescontoAlcool (valorCarro,DescontoAlcool);
				valorPago = valorCarro - valorDesconto;
				
				System.out.println("O valor do desconto do carro a alcool eh de:"+ valorDesconto);
				System.out.println("O valor pago é de: "+valorPago);
				
			
				
			}
			else if (tipoCarro.equalsIgnoreCase("Gasolina")) {
				valorDesconto =calcularDescontoGasolina(valorCarro,DescontoGasolina);
				valorPago=valorCarro -valorDesconto;
				System.out.println("O valor do desconto do carro a gasolina eh de:"+ valorDesconto);
				System.out.println("O valor pago é de: "+valorPago);
				
				
			}else { 
		     valorDesconto = calcularDescontoDiessel (valorCarro,DescontoDiesel);
			 valorPago = valorCarro - valorDesconto;
		     System.out.println("O valor do desconto do carro a diesel eh de:" + valorDesconto);
			 System.out.println("O valor pago é de: " +valorPago);
			}
		}while(valorCarro != 0);
		
	}
	
	public static double calcularDesconto(double valorCarro,double valorDesconto) {
		double desconto;
		desconto = valorCarro * valorDesconto;
		return desconto;
	}
	
		public static double calcularDescontoAlcool(double valorCarro, double valorDescontoAlcool) {
			double desconto; 
			
			desconto = valorCarro * valorDescontoAlcool;
			return desconto;
		}
			
			public static double calcularDescontoGasolina(double valorCarro, double valorDescontoGasolina){
				double desconto; 
				
				desconto = valorCarro * valorDescontoGasolina;
				return desconto;
			}
			
			public static double calcularDescontoDiessel(double valorCarro, double valorDescontoDiesel){
				double desconto; 
					
				desconto = valorCarro * valorDescontoDiesel;
				return desconto;
			}
}
