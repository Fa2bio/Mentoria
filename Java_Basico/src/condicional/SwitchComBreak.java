package condicional;

import java.util.Scanner;

public class SwitchComBreak {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		System.out.print("Digite a cor: ");
		String cor = entrada.nextLine();
		
		switch (cor.toLowerCase()){
		case "preto": {
			System.out.println("A cor é preta");
			break;
		}case "amarela":{
			System.out.println("A cor é amarela");
			break;
		}case "Verde": {
			System.out.println("A cor é verde");
			break;
		}
		default:
			System.out.println("Cor não tipada");
		}
	}
}
