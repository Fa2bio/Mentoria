package modulo2.orientacao.abstracao;

public class TesteForma {
	public static void main(String[] args) {
		Circulo c = new Circulo();
		System.out.println(c.calcularArea(10, 10));
		System.out.println(c.calcularVolume(20));
		System.out.println(c.calcularArea(10, 10));
	}
}
