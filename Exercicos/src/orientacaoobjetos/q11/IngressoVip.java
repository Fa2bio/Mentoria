package orientacaoobjetos.q11;

public class IngressoVip extends Ingresso{

	double valorAdicional;
	
	public IngressoVip(double valor, double valorAdicional) {
		this(valor, valorAdicional, 10000.00);		
	}

	public IngressoVip(double valorPai, double valorAdicional, double valor) {
		super(valorPai);
		this.valor = valor;
		this.valorAdicional = super.valor + valorAdicional;
	}
	public void brincar() {
		System.out.println(super.valor);
		System.out.println(this.valor);
	}
	public double getValorAdicional() {
		return valorAdicional;
	}

	public void setValorAdicional(double valorAdicional) {
		this.valorAdicional = valorAdicional;
	}
	
	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public String imprimirValorVip() {
		return "O valor do ingresso vip eh de: " + this.valorAdicional;
	}
}
