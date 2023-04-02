package avancado.onetomany;

import java.util.ArrayList;
import java.util.List;

public class Pessoa {
	String nome;
	List<Endereco> enderecos = new ArrayList<>();
	
	public Pessoa(String nome) {
		this.nome = nome;
	}
	
	void adicionar(Endereco endereco) {
		this.enderecos.add(endereco);
	}
}
