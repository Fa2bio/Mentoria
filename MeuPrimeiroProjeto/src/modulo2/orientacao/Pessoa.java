package modulo2.orientacao;

import java.util.ArrayList;
import java.util.List;

public class Pessoa {
	String nome;
	
	Endereco endereco;
	List<Endereco> enderecos = new ArrayList<>();
	
	public Pessoa(String nome, Endereco endereco) {
		this.nome = nome;
		this.endereco = endereco;
	}
	
	public void adicionarEnderecos(Endereco e) {
		this.enderecos.add(e);
		endereco.pessoa=this;
	}
	
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
}
