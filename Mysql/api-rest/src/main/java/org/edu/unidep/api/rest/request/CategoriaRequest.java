package org.edu.unidep.api.rest.request;

import javax.validation.constraints.Size;

import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.edu.unidep.api.command.CategoriaCommand;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.smallrye.common.constraint.NotNull;

public record CategoriaRequest(

        @Schema(example = "LIMPEZA")
        @NotNull @Size(min = 5, max = 80)
        @JsonProperty("nome_categoria")
        String nome
) {

    public static CategoriaCommand toCommand(CategoriaRequest request) {
        return new CategoriaCommand(request.nome);
    }

}
