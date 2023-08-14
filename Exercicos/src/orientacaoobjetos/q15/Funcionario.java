package orientacaoobjetos.q15;

public class Funcionario {

	private String nome;
	private String sobreNome;
	private double salarioAnual;
	private static int total_funcionarios=0;
	
	public Funcionario(String nome, String sobreNome, double salarioAnual) {
		this.nome = nome;
		this.sobreNome = sobreNome;
		this.salarioAnual = salarioAnual;
		total_funcionarios++;
	}
	
	public void aumentarSalario() {
		this.salarioAnual += salarioAnual * (10.0/100.0);
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobreNome() {
		return sobreNome;
	}

	public void setSobreNome(String sobreNome) {
		this.sobreNome = sobreNome;
	}

	public double getSalarioAnual() {
		return salarioAnual;
	}

	public void setSalarioAnual(double salarioAnual) {
		this.salarioAnual = salarioAnual;
	}

	public static int getTotal_funcionarios() {
		return total_funcionarios;
	}

}
