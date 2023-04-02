package intermediario.polimorfismo.dinamico;

public class Carro extends Veiculo implements CarroMetodos{

	protected double velocidade = 0;
	
	@Override
	public int numRodas() {
		// TODO Auto-generated method stub
		return 4;
	}

	@Override
	public void acelerar() {
		this.velocidade += 20;
		
	}

}
