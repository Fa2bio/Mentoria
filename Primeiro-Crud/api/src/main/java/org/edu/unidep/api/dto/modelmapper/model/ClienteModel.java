package org.edu.unidep.api.dto.modelmapper.model;

import java.util.List;

public class ClienteModel {

	private String nome;
	private String cpf;
	private EnderecoModel endereco;
	private List<LivroResumoModel> livros;
	private List<FuncionarioResumoModel> funcionarios;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public List<LivroResumoModel> getLivros() {
		return livros;
	}
	public EnderecoModel getEndereco() {
		return endereco;
	}
	public void setEndereco(EnderecoModel endereco) {
		this.endereco = endereco;
	}
	public void setLivros(List<LivroResumoModel> livros) {
		this.livros = livros;
	}
	public List<FuncionarioResumoModel> getFuncionarios() {
		return funcionarios;
	}
	public void setFuncionarios(List<FuncionarioResumoModel> funcionarios) {
		this.funcionarios = funcionarios;
	}

}
