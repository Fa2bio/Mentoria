package condicional;

import java.util.Scanner;

public class IfElse {
	public static void main(String[] args) {
		int a = 30;
		int b = 40;
		
		int c;
		
		Scanner entrada = new Scanner(System.in);
		c = entrada.nextInt();
		
		if(a < b && a < c){
			System.out.println("A eh o menor");
		}if(b < c){
			System.out.println("B eh o menor");
		}else {
			System.out.println("C eh o menor");
		}
	}
}
