package org.edu.unidep.api.dto.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ClienteResponse(
		@JsonProperty("codigo_cliente")
	    Long id,
	    
	    @JsonProperty("nome")
	    String nome,
	    
	    @JsonProperty("email")
	    String email,
	    
	    @JsonProperty("pedidos")
	    List<PedidoResumoResponse> pedidos		
		) {

}
