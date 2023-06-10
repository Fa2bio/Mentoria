package org.edu.unidep.api.dto.model;

import java.time.LocalDate;
import java.util.List;

import org.edu.unidep.api.dto.request.ItemRequest;

public record OrcamentoModel(
		LocalDate data,
		LocalDate dataValidade,
		List<ItemRequest> itens
		) {
}
