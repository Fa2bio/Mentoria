package orientacaoobjetos.q13;

public class Principal {

	public static void main(String[] args) {
		
		CalculadoraCientifica calc1= new CalculadoraCientifica();
		System.out.println("Soma:"+ calc1.somar(2,4) );
		System.out.println("Subtração:"+ calc1.subtrair(2,4) );
		System.out.println("Multiplicação:"+ calc1.multiplicar(2,4) );
		System.out.println("Divisão:"+ calc1.dividir(2,10) );
		
		//CalculadoraCientifica calc2= new CalculadoraCientifica();
		
		System.out.println("Raiz quadrada de 144 é: "+ calc1.raizQuadrada(144));
		System.out.println("Potência - três elevado a dois: "+ calc1.calcularPotencia(3, 2));
		
	}
}
