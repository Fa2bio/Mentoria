package org.edu.unidep.api.command;

import java.time.LocalDate;

public record PessoaCommand(
        String nome,
        LocalDate dataAniversario,
        String tipoSanguineo,
        String endereco,
        String cpf
) {
}
