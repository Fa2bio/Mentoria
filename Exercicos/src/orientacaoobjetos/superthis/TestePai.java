package orientacaoobjetos.superthis;

public class TestePai {

	protected String nome;
	protected String sobreNome;
	
	public TestePai(String nome) {
		this.nome = nome;
		this.sobreNome = null;
	}
	
	public TestePai(String nome, String sobreNome) {
		this.nome = nome;
		this.sobreNome = sobreNome;
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
	
	
}
