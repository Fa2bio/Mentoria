package modulo2.orientacao;

public class Circulo extends Forma{

	@Override
	double calcularVolume(int largura) {
		return Math.PI*largura/2;
	}

	@Override
	double calcularArea(int altura, int largura) {
		return Math.PI*(largura/2);
	}

}
