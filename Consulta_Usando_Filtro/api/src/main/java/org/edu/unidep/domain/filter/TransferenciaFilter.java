package org.edu.unidep.domain.filter;

import java.time.OffsetDateTime;

public class TransferenciaFilter {

	private Long contaId;
	
	private OffsetDateTime dataCriacaoInicio;
	
	private OffsetDateTime dataCriacaoFim;
	
	private String nomeOperador;

	public Long getContaId() {
		return contaId;
	}

	public void setContaId(Long contaId) {
		this.contaId = contaId;
	}

	public OffsetDateTime getDataCriacaoInicio() {
		return dataCriacaoInicio;
	}

	public void setDataCriacaoInicio(OffsetDateTime dataCriacaoInicio) {
		this.dataCriacaoInicio = dataCriacaoInicio;
	}

	public OffsetDateTime getDataCriacaoFim() {
		return dataCriacaoFim;
	}

	public void setDataCriacaoFim(OffsetDateTime dataCriacaoFim) {
		this.dataCriacaoFim = dataCriacaoFim;
	}

	public String getNomeOperador() {
		return nomeOperador;
	}

	public void setNomeOperador(String nomeOperador) {
		this.nomeOperador = nomeOperador;
	}
	
}
