package intermediario.polimorfismo.dinamico;

public class Teste {
	public static void main(String[] args) {
		Carro c = new Civic();
		Ferrari f = new Ferrari();
		
		f.acelerar();
		c.acelerar();
		
		System.out.println(f.velocidade);
		System.out.println(c.velocidade);
	}
}
