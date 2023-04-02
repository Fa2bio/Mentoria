package repeticao;

import java.util.Scanner;

public class While {
	public static void main(String[] args) {
		int a;
		int b;
		int c = 1;
		
		Scanner entrada = new Scanner(System.in);

		while(c!=0) {
			System.out.print("Digite o valor do primeiro numero: ");
			a = entrada.nextInt();
			System.out.print("Digite o valor do segundo numero: ");
			b = entrada.nextInt();
						
			if(a < b){
				System.out.println("A eh o menor");
			}else{
				System.out.println("B eh o menor");
			}
			
			System.out.print("Digite 0 para sair ou qualquer outro número para tentar novamente: ");
			c = entrada.nextInt();
		}
		
	}
}
