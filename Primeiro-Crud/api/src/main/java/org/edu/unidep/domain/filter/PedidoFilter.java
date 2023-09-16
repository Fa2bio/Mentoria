package org.edu.unidep.domain.filter;

import java.time.LocalDate;

public class PedidoFilter {

	private LocalDate dataPedidoInicio;
	private LocalDate dataPedidoFim;
	private Long clienteId;
	private Long funcionarioId;
	
	public LocalDate getDataPedidoInicio() {
		return dataPedidoInicio;
	}
	public void setDataPedidoInicio(LocalDate dataPedidoInicio) {
		this.dataPedidoInicio = dataPedidoInicio;
	}
	public LocalDate getDataPedidoFim() {
		return dataPedidoFim;
	}
	public void setDataPedidoFim(LocalDate dataPedidoFim) {
		this.dataPedidoFim = dataPedidoFim;
	}
	public Long getClienteId() {
		return clienteId;
	}
	public void setClienteId(Long clienteId) {
		this.clienteId = clienteId;
	}
	public Long getFuncionarioId() {
		return funcionarioId;
	}
	public void setFuncionarioId(Long funcionarioId) {
		this.funcionarioId = funcionarioId;
	}
	
	
}
