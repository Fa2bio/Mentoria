package org.edu.unidep.domain.filter;

import java.time.OffsetDateTime;

public class TransferenciaFilter {

	private OffsetDateTime dataTransferenciaInicio;
	
	private OffsetDateTime dataTransferenciaFim;
	
	private String nomeOperador;
	
	private Long contaId;

	public OffsetDateTime getDataTransferenciaInicio() {
		return dataTransferenciaInicio;
	}

	public void setDataTransferenciaInicio(OffsetDateTime dataTransferenciaInicio) {
		this.dataTransferenciaInicio = dataTransferenciaInicio;
	}

	public OffsetDateTime getDataTransferenciaFim() {
		return dataTransferenciaFim;
	}

	public void setDataTransferenciaFim(OffsetDateTime dataTransferenciaFim) {
		this.dataTransferenciaFim = dataTransferenciaFim;
	}

	public String getNomeOperador() {
		return nomeOperador;
	}

	public void setNomeOperador(String nomeOperador) {
		this.nomeOperador = nomeOperador;
	}

	public Long getContaId() {
		return contaId;
	}

	public void setContaId(Long contaId) {
		this.contaId = contaId;
	}
	
}
