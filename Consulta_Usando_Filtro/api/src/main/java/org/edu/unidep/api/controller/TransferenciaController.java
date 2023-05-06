package org.edu.unidep.api.controller;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.edu.unidep.api.dto.model.TransferenciaModel;
import org.edu.unidep.domain.filter.TransferenciaFilter;
import org.edu.unidep.domain.service.TransferenciaService;

@Path("/transferencias")
public class TransferenciaController {

	@Inject
	private TransferenciaService transferenciaService;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<TransferenciaModel> todasTransferencias(){
		TransferenciaFilter f = new TransferenciaFilter();
		f.setDataCriacaoInicio(OffsetDateTime.of(2019, 1, 1, 12, 30, 10, 05, ZoneOffset.UTC));
		f.setDataCriacaoFim(OffsetDateTime.of(2023, 6, 1, 12, 30, 10, 05, ZoneOffset.UTC));
//		f.setNomeOperador("Beltrano");
		return transferenciaService.transferenciasUsandoFiltro(f);
	}
}
