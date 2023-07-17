package funcao;

import interfaces.Calcular;

public class Somar implements Calcular{

	@Override
	public double executar(double a, double b) {
		return a+b;
	}

	@Override
	public boolean comparar(double a, double b) {
		if(a>b) return true;
		return false;
	}
	

}
