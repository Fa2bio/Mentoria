package org.edu.unidep.api.dto.model;

import java.math.BigDecimal;

import org.edu.unidep.api.dto.request.ProdutoIdRequest;

public record ItemModel(
		Integer quantidade,
		BigDecimal valorUnitario,
		BigDecimal valorTotal,
		ProdutoIdRequest produto
		) {

}
