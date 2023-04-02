package condicional;

import java.util.Scanner;

public class SwitchSemBreak {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		String cor = entrada.nextLine();
		
		switch (cor.toLowerCase()){
		case "preto": {
			System.out.println("A cor é preta");
		}case "amarela":{
			System.out.println("A cor é amarela");
		}case "Verde": {
			System.out.println("A cor é verde");
		}
		default:
			System.out.println("Cor não tipada");
		}
	}
}
