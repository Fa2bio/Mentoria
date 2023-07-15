package introducaoAoJava.q06;

public class Q6 {
	public static void main(String[] args) {
		int a = 10;
		int b = 50;
		
		System.out.println("Valor de A: " + a);
		System.out.println("Valor de B: " + b);
		
		int c = b;
		
		b = a;
		a = c;
		
		System.out.println("Valor de trocado de A: " + a);
		System.out.println("Valor de trocado de B: " + b);
	}
}
