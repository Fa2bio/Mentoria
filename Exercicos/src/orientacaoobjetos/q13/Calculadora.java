package orientacaoobjetos.q13;

public class Calculadora {

	public double somar(double a,double b) {
		return a+b;
	}
	
	public double subtrair(double a, double b) {
		return a-b;
	}
	
	public double multiplicar(double a, double b) {
		return a*b;
	}
	
	public double dividir (double numerador,double divisor) {
		if(divisor!=0) {
			return numerador/divisor;
		}else {
			throw new ArithmeticException();
		}
	}
}
