package funcao;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Funcao2 {

	public static void main(String[] args) {
		List<Integer> lista = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		
		System.out.println("Imprime todos os numeros:");
		avaliaExpressao(lista, (n) -> true);
		
		System.out.println("Não Imprime nenhum dos numeros:");
		avaliaExpressao(lista, (n) -> false);
		
		System.out.println("Imprime os numeros pares:");
		avaliaExpressao(lista, (n) -> n%2==0);
		
		System.out.println("Imprime os numeros maiores que 8:");
		avaliaExpressao(lista, (n) -> n>8);
	}
	
	public static void avaliaExpressao(List<Integer> lista, Predicate<Integer> predicate) {
		lista.forEach(n -> {
			if(predicate.test(n)) {
				System.out.println(n);
			}
		});
	}
}
