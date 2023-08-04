package orientacaoobjetos.q10;

import java.time.LocalDate;

public class Jogador {

	private String nome;
	private String posicao;
	private LocalDate dataDeNascimento;
	private String nacionalidade;
	private double altura;
	private double peso;
	
	public Jogador(String nome, String posicao, LocalDate dataDeNascimento, String nacionalidade,
			double altura, double peso) {
		this.nome = nome;
		this.posicao = posicao;
		this.dataDeNascimento = dataDeNascimento;
		this.nacionalidade = nacionalidade;
		this.altura = altura;
		this.peso = peso;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("O nome do jogador eh: ");
		sb.append(nome);
		sb.append(" , a sua posicao eh: ");
		sb.append(posicao);
		sb.append(" , a sua data de nascimento eh: ");
		sb.append(dataDeNascimento.toString());
		sb.append(", a sua nacionalidade eh: ");
		sb.append(nacionalidade);
		sb.append(" , a sua altura eh: ");
		sb.append(altura);
		sb.append(" e seu peso eh: ");
		sb.append(peso);
		
		return sb.toString();
	}
	
	public int idadeJogador(int anoAtual) {
		int anoNascimento = this.dataDeNascimento.getYear();
		return anoAtual - anoNascimento;
	}
	
	public int anosRestastantes(int idadeJogador) {
		if(this.posicao.equalsIgnoreCase("defesa")) {
			return 40 - idadeJogador;
		}
		else if(this.posicao.equalsIgnoreCase("meio-campo")) {
			return 38 - idadeJogador;
		}
		else {
			return 35 - idadeJogador;
		}
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPosição() {
		return posicao;
	}

	public void setPosição(String posicao) {
		this.posicao = posicao;
	}

	public LocalDate getDataDeNascimento() {
		return dataDeNascimento;
	}

	public void setDataDeNascimento(LocalDate dataDeNascimento) {
		this.dataDeNascimento = dataDeNascimento;
	}

	public String getNacionalidade() {
		return nacionalidade;
	}

	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

}
