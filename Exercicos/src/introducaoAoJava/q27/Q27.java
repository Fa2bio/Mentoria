package introducaoAoJava.q27;

import java.util.Scanner;

public class Q27 {
	public static void main(String[] args) {
		double valorDesconto;
		double valorCarro;
		double valorPago;
		double descontoAlcool = 25.0/100.0;
		double descontoGasolina = 21.0/100.0;
		double descontoDiesel = 14.0/100.0;
		
		String tipoCarro;
		
		Scanner entrada = new Scanner(System.in);
		tipoCarro = entrada.next();
		if(tipoCarro.equalsIgnoreCase("Alcool")) {
			//ToDo
		}else if(tipoCarro.equalsIgnoreCase("Gasolina")) {
			//ToDo
		}else {
			//ToDo
		}
		
		entrada.close();
	}
	
	public static double calcularDesconto(double valorCarro,double valorDesconto) {
		double desconto;
		desconto = valorCarro * valorDesconto;
		return desconto;
	}
}
