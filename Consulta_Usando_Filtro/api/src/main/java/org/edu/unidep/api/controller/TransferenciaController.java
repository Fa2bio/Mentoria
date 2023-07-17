package org.edu.unidep.api.controller;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.edu.unidep.api.dto.model.TransferenciaModel;
import org.edu.unidep.domain.filter.TransferenciaFilter;
import org.edu.unidep.domain.service.TransferenciaService;

@Path("/transferencias")
public class TransferenciaController {

	/*http://localhost:8080/transferencias?dataCriacaoInicio="2018-01-01T12:00:00Z"&dataCriacaoFim="2020-01-01T12:00:00Z"*/
	
	@Inject
	private TransferenciaService transferenciaService;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<TransferenciaModel> todasTransferencias(@RequestBody TransferenciaFilter filter){
		return transferenciaService.transferenciaUsandoFiltro(filter);
	}
}
