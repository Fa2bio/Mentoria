package orientacaoobjetos.q11;

public class Ingresso {

	protected double valor;
	
	public Ingresso(double valor) {
		this.valor = valor;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}
	
	public String imprimirValor() {
		return "O valor do ingresso tradicional eh de: " + this.valor;
	}
	
}
