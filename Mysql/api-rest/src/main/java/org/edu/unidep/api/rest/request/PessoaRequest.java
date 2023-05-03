package org.edu.unidep.api.rest.request;

import java.time.LocalDate;

import javax.validation.constraints.Size;

import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.edu.unidep.api.command.PessoaCommand;
import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.smallrye.common.constraint.NotNull;

public record PessoaRequest(

        @Schema(example = "LIMPEZA")
        @NotNull @Size(min = 5, max = 80)
        @JsonProperty("nome")
        String nome,

        @Schema(example = "1990-05-20")
        @JsonProperty("data_aniversario")
        LocalDate dataAniversario,

        @Schema(example = "O+")
        @NotNull @Size(min = 1, max = 5)
        @JsonProperty("tipo_sanguineo")
        String tipoSanguineo,

        @Schema(example = "Avenida Brasil")
        @NotNull @Size(min = 5, max = 120)
        @JsonProperty("endereco")
        String endereco,

        @Schema(example = "12345678912")
        @NotNull @Size(min = 14, max = 14)
        @JsonProperty("cpf")
        @CPF
        String cpf
) {

    public static PessoaCommand toCommand(PessoaRequest request) {

        return new PessoaCommand(
                request.nome,
                request.dataAniversario,
                request.tipoSanguineo,
                request.endereco,
                request.cpf
         );
    }

}