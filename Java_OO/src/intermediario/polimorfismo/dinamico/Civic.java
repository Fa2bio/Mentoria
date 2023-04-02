package intermediario.polimorfismo.dinamico;

public class Civic extends Carro{

	@Override
	public void acelerar() {
		super.velocidade += 30;
	}
}
