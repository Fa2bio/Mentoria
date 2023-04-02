package basico.abstrato;

public class Quadrado extends Forma{

	int area;
	
	@Override
	public void calcularArea() {
		area = this.altura * this.largura;
		
	}

}
