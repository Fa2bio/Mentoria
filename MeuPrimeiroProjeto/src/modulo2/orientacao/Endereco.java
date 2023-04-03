package modulo2.orientacao;

public class Endereco {
	String rua;
	Pessoa pessoa;
	public Endereco(String rua) {
		this.rua = rua;
	}
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	
	public void adicionarPessoa(Pessoa p) {
		this.pessoa = p;
	}
	
}
