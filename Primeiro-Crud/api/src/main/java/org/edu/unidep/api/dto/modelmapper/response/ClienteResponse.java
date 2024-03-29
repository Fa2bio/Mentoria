package org.edu.unidep.api.dto.modelmapper.response;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.Link;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ClienteResponse {

	@JsonProperty("nome")
	private String nome;
	
	@JsonProperty("cpf")
	private String cpf;
	
	@JsonProperty("endereco")
	private EnderecoResponse endereco;
	
	@JsonProperty("livros")
	private List<LivroResumoResponse> livros;
	
	@JsonProperty("funcionarios")
	private List<FuncionarioResumoResponse> funcionarios;
	
	@JsonProperty("pedidos")
	private List<PedidoResumoResponse> pedidos;
	
	private List<Link> links = new ArrayList<>();
	
	public void addLink(Link link) {
		this.links.add(link);
	}
	
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
	public List<LivroResumoResponse> getLivros() {
		return livros;
	}
	public EnderecoResponse getEndereco() {
		return endereco;
	}
	public void setEndereco(EnderecoResponse endereco) {
		this.endereco = endereco;
	}
	public void setLivros(List<LivroResumoResponse> livros) {
		this.livros = livros;
	}
	public List<FuncionarioResumoResponse> getFuncionarios() {
		return funcionarios;
	}
	public void setFuncionarios(List<FuncionarioResumoResponse> funcionarios) {
		this.funcionarios = funcionarios;
	}
	public List<PedidoResumoResponse> getPedidos() {
		return pedidos;
	}
	public void setPedidos(List<PedidoResumoResponse> pedidos) {
		this.pedidos = pedidos;
	}
	public List<Link> getLinks() {
		return links;
	}
	public void setLinks(List<Link> links) {
		this.links = links;
	}
}
