package org.edu.unidep.api.rest.request;

import java.time.LocalDate;

import javax.validation.constraints.Size;

import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.edu.unidep.api.command.ProdutoCommand;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.smallrye.common.constraint.NotNull;

public record ProdutoRequest(

        @Schema(example = "LIMPEZA")
        @NotNull @Size(min = 5, max = 80)
        @JsonProperty("descricao")
        String descricao,
        
        @Schema(example = "KG")
        @NotNull @Size(min = 1, max = 5)
        @JsonProperty("unidade_medida")
        String unidadeMedida,

        @Schema(example = "1990-05-20")
        @JsonProperty("data_vencimento")
        LocalDate dataVencimento
) {

    public static ProdutoCommand toCommand(ProdutoRequest request) {

        return new ProdutoCommand(
                request.descricao,
                request.unidadeMedida,
                request.dataVencimento
       );
    }

}