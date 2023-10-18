package org.edu.unidep.api.dto.modelmapper.response;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.Link;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PedidoResponse {

	@JsonProperty("uuidCode")
	private String uuidCode;

	@JsonProperty("dataEmissao")
	private LocalDate dataEmissao;
	
	@JsonProperty("valor")
	private BigDecimal valor;
	
	@JsonProperty("cliente")
	private ClienteResumoResponse cliente;
	
	@JsonProperty("funcionario")
	private FuncionarioResumoResponse funcionario;
	
	@JsonProperty("itens")
	private List<ItemResumoResponse> itens;
	
	@JsonProperty("links")
	private List<Link> links = new ArrayList<>();
	
	public void addLink(Link link) {
		this.links.add(link);
	}

	public String getUuidCode() {
		return uuidCode;
	}

	public void setUuidCode(String uuidCode) {
		this.uuidCode = uuidCode;
	}

	public LocalDate getDataEmissao() {
		return dataEmissao;
	}

	public void setDataEmissao(LocalDate dataEmissao) {
		this.dataEmissao = dataEmissao;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public ClienteResumoResponse getCliente() {
		return cliente;
	}

	public void setCliente(ClienteResumoResponse cliente) {
		this.cliente = cliente;
	}

	public FuncionarioResumoResponse getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(FuncionarioResumoResponse funcionario) {
		this.funcionario = funcionario;
	}

	public List<ItemResumoResponse> getItens() {
		return itens;
	}

	public void setItens(List<ItemResumoResponse> itens) {
		this.itens = itens;
	}

	public List<Link> getLinks() {
		return links;
	}

	public void setLinks(List<Link> links) {
		this.links = links;
	}
}
