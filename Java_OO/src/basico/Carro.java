package basico;

public class Carro implements CarroMetodos{

	double velocidade = 0;
	
	@Override
	public void acelerar() {
		velocidade += 10;
		
	}

}
