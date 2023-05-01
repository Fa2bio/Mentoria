package org.edu.unidep.api.command;

import java.math.BigDecimal;
import java.time.Month;

public record ProdutoQuery(BigDecimal quantidadeTotalVendas, Month mesAtual, String unidadeMedida) {
}
