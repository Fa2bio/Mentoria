package modulo2.orientacao.onetomany;

import java.util.ArrayList;
import java.util.List;

public class Pessoa {
	String nome;
	List<Endereco> enderecos = new ArrayList<>();
	
	public Pessoa(String nome) {
		this.nome = nome;
	}
	
	public void adicionarEnderecos(Endereco endereco) {
		this.enderecos.add(endereco);
		endereco.pessoa=this;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}	
}
