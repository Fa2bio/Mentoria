package modulo2.orientacao.polimorfismo.dinamico;

public class TesteSerVivo {
	public static void main(String[] args) {
		Cachorro c = new Cachorro();
		Peixe p = new Peixe();
		c.respirar();
		p.respirar();
	}
}
