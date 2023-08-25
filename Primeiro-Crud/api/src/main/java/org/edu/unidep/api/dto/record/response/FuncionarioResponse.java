package org.edu.unidep.api.dto.record.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public record FuncionarioResponse(
		
		@JsonProperty("nome")
		String nome,
		
		@JsonProperty("cpf")
		String cpf,
		
		@JsonProperty("endereco")
		EnderecoResponse endereco,
		
		@JsonProperty("cliente")
		List<ClienteResumoResponse> clientes
		
		) {

}
