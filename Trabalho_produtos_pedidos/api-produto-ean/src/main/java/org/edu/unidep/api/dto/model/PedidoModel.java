package org.edu.unidep.api.dto.model;

import java.time.LocalDate;

import org.edu.unidep.api.dto.request.ClienteIdRequest;
import org.edu.unidep.api.dto.request.OrcamentoIdRequest;

public record PedidoModel(
		
		LocalDate data,
		
		ClienteIdRequest cliente,
		
		OrcamentoIdRequest orcamento
		) {

}