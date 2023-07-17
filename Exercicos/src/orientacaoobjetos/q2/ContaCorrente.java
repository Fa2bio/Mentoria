package orientacaoobjetos.q2;

public class ContaCorrente {

	private String numeroConta;
	private String nome;
	private double saldo;
	
	public ContaCorrente(String numeroConta, String nome) {
		this.numeroConta = numeroConta;
		this.nome = nome;
		this.saldo = 0.0;
	}
	
	public ContaCorrente(String numeroConta, String nome, double saldo) {
		this.numeroConta = numeroConta;
		this.nome = nome;
		this.saldo = saldo;
	}
	
	public boolean saque(double valor) {
		if(getSaldo() > 0 && getSaldo() >= valor) {
			double novoSaldo = getSaldo() - valor;
			setSaldo(novoSaldo);
			return true;
		}else {
			return false;
		}
		
	}
	
	public void deposito(double valor) {
		double novoSaldo = getSaldo() + valor;
		setSaldo(novoSaldo);
	}
	
	public void alterarNome(String nomeAlterado) {
		setNome(nomeAlterado);
	}
	
	public String getNumeroConta() {
		return numeroConta;
	}
	public void setNumeroConta(String numeroConta) {
		this.numeroConta = numeroConta;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	
}
