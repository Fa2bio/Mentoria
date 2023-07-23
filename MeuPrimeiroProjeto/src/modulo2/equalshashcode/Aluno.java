package modulo2.equalshashcode;

import java.util.Objects;

public class Aluno {

	private String nome;
	private String sobreNome;
	
	public Aluno(String nome, String sobreNome) {
		super();
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
	
	@Override
	public int hashCode() {
		return Objects.hash(nome, sobreNome);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aluno other = (Aluno) obj;
		return Objects.equals(nome, other.nome) && Objects.equals(sobreNome, other.sobreNome);
	}	
	
}
