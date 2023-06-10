package org.edu.unidep.api.dto.request;

import java.time.LocalDate;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.edu.unidep.api.dto.model.PedidoModel;

import com.fasterxml.jackson.annotation.JsonProperty;

public record PedidoRequest(
		
		@JsonProperty("data_emissao")
        @NotNull
		LocalDate data,
		
		@JsonProperty("cliente")
		@NotNull
		@Valid
		ClienteIdRequest cliente,
		
		@JsonProperty("orcamento")
		@NotNull 
		@Valid
		OrcamentoIdRequest orcamento		
		) {

	   public static PedidoModel toModel(PedidoRequest input) {
	        return new PedidoModel(
	                input.data,
	                input.cliente,
	                input.orcamento
	       );
	   }
}
