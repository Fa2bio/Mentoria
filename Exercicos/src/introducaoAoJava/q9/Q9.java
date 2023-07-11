package introducaoAoJava.q9;

import java.util.Scanner;

public class Q9 {

	public static void main(String[] args) {
		
		Scanner entrada = new Scanner(System.in);
		double valorDepositado;		
        double totalRendimento;        
        System.out.println("Digite o valor depositado: ");
        valorDepositado = entrada.nextDouble();     
      
        System.out.println("O valor depositado é: " + valorDepositado);
        
        System.out.println("O total com rendimentos é: " + calcularTotalRendimento(valorDepositado) );
        entrada.close();	
	}
	    
    private static double calcularPorcentagem(double valorDepositado) {
    	double porcentagem;
    	double juroFixo = 0.07/100;
    	porcentagem = valorDepositado * juroFixo;
    	return porcentagem;
    }
    
    
    private static double calcularTotalRendimento(double valorDepositado){
    	double rendimentoTotal;
    	rendimentoTotal= valorDepositado + calcularPorcentagem(valorDepositado);
    return rendimentoTotal;
    }
}
