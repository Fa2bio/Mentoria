package modulo1.primeiro;

public class OperadoresLogicos2 {
	public static void main(String[] args) {
		int a = 10;
		int b = 20;
		int c = 30;
		
		System.out.println(a==b && a!=c);
		System.out.println(!(a==b && a!=c));
		System.out.println(a==b || a!=c);
		System.out.println(!(a==b || a!=c));
		
	}
}
