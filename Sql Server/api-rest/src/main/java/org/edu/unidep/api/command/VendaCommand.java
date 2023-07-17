package org.edu.unidep.api.command;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.edu.unidep.domain.model.Produto;

public record VendaCommand(
            BigDecimal quantidade,
            BigDecimal valorTotal,
            String unidadeMedida,
            LocalDate data,
            Produto produto
        ) {
}
