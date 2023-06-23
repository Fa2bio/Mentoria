package funcao;

import interfaces.Calcular;
import interfaces.CalcularFuncional;

public class Teste1 {

	public static void main(String[] args) {
		Calcular somar = new Somar();
		System.out.println(somar.executar(10.5, 10.6));
		
		Calcular multiplicar = new Multiplicar();
		System.out.println(multiplicar.executar(2, 3));
		
		
		System.out.println("Lambda ----");
		
		CalcularFuncional subtrair = (x,y) -> {
			return x-y;
		};
		
		System.out.println(subtrair.executar(10,2));
		
		CalcularFuncional dividir = (x,y) -> {
			return x/y;
		};
		
		System.out.println(dividir.executar(10,2));
	}
}
