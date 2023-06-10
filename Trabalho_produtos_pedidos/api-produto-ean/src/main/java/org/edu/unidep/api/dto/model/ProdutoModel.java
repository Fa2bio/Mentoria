package org.edu.unidep.api.dto.model;

import java.time.LocalDate;

public record ProdutoModel(
		String nome, 
		String categoria, 
		String codigoEan, 
		LocalDate dataValidade) {

}
