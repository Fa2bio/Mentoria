package modulo1.primeiro;

public class OperadoresAritmeticos {
	public static void main(String[] args) {
		int a = 10;
		int b = 19;
		int total = 0;
		
		total = a+b;
		System.out.println("Total adição: "+total);
		
		total = a-b;
		System.out.println("Total subtração: "+total);
		
		total = a*b;
		System.out.println("Total multi: "+total);
		
		total = a/b;
		System.out.println("Total divi: "+total);
		
		total = a%b;
		System.out.println("Total resto: "+total);
		
		total = ++a;
		System.out.println("Total incremento: "+total);
		
		total = --a;
		System.out.println("Total decremento: "+total);
	}
}
