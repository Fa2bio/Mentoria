package org.edu.unidep.api.command;

import java.time.LocalDate;

public record ProdutoCommand(String descricao, String unidadeMedida, LocalDate dataVencimento) {
}
