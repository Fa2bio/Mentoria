package funcao;

import java.util.Arrays;
import java.util.List;

public class Funcao {
	
	public static void main(String[] args) {
		List<Integer> lista = Arrays.asList(1,2,3,4,5,6,7,8,10);
		for (Integer numero : lista) {
			System.out.println(numero + " Eh Par ? " + ehPar(numero));
		}
		
		System.out.println("\nLambda ----");
		lista.forEach((num) -> {
			System.out.println(num%2==0);
		});
		
		
		System.out.println("\nLambda ----");
		lista.forEach((numo)-> System.out.println(numo));
		
		System.out.println("\nMethod Reference ----");
		lista.forEach(System.out::println);
	}
	
	public static boolean ehPar(Integer num) {
		return num%2==0;
	}
}
