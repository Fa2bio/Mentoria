package orientacaoobjetos.q01;

import java.time.LocalDate;

public class Pessoa {

	private String nome;
	private LocalDate dataNascimento;
	private double altura;
	
	public Pessoa(String nome, LocalDate dataNascimento, double altura) {
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.altura = altura;
	}
	
	public String imprimir() {
		return "O nome da pessoa eh " + nome +
				" e sua data de nascimento eh " + dataNascimento +
				" a sua altura eh de " + altura;
	}
	
	public int calcularIdade(int ano) {
		int anoNascimento = dataNascimento.getYear();
		return ano - anoNascimento;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public LocalDate getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public double getAltura() {
		return altura;
	}
	public void setAltura(double altura) {
		this.altura = altura;
	}

}
