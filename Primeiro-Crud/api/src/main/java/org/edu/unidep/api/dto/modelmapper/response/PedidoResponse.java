package org.edu.unidep.api.dto.modelmapper.response;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class PedidoResponse {

	private String uuidCode;

	private LocalDate dataEmissao;
	
	private BigDecimal valor;
	
	private ClienteResumoResponse cliente;
	
	private FuncionarioResumoResponse funcionario;
	
	private List<ItemResumoResponse> itens;

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

}
