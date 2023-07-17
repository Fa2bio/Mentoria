package modulo1.primeiro;

public class Else {
	public static void main(String[] args) {
		int a = 10;
		int b = 5;
		if(a==b) {
			
		}else if(a<b) {
			
		}else {
			System.out.println("B é menor que A");
		}
		
		switch (args.length) {
		case 1: {
			
			System.out.println("Um");
			break;
		}
		case 2:
			System.out.println("Dois");
			break;
		default:
			System.out.println("Mais de dois");
		}
	}
}
