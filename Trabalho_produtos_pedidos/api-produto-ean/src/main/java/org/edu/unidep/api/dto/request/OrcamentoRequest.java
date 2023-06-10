package org.edu.unidep.api.dto.request;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.edu.unidep.api.dto.model.OrcamentoModel;

import com.fasterxml.jackson.annotation.JsonProperty;


public record OrcamentoRequest(
		
        @NotNull
        @JsonProperty("data")
		LocalDate data,
		
        @NotNull 
        @JsonProperty("data_validade")
		LocalDate dataValidade,
		
        @NotNull 
        @Valid
        @JsonProperty("itens")
		List<ItemRequest> itens
		) {

    public static OrcamentoModel toModel(OrcamentoRequest input) {
        return new OrcamentoModel(
                input.data,
                input.dataValidade,
                input.itens
       );
    }
}
