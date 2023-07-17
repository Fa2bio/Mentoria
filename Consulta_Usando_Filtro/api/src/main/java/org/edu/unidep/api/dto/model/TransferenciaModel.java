package org.edu.unidep.api.dto.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import org.edu.unidep.domain.model.TransferenciaTipo;

public class TransferenciaModel {

	private OffsetDateTime dataTransferencia;
	
	private BigDecimal valor;
	
	private TransferenciaTipo tipo;
	
	private String nomeOperador;

	public OffsetDateTime getDataTransferencia() {
		return dataTransferencia;
	}

	public void setDataTransferencia(OffsetDateTime dataTransferencia) {
		this.dataTransferencia = dataTransferencia;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public TransferenciaTipo getTipo() {
		return tipo;
	}

	public void setTipo(TransferenciaTipo tipo) {
		this.tipo = tipo;
	}

	public String getNomeOperador() {
		return nomeOperador;
	}

	public void setNomeOperador(String nomeOperador) {
		this.nomeOperador = nomeOperador;
	}
	
	
}
