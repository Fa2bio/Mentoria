package org.edu.unidep.api.dto.request;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.edu.unidep.api.dto.model.ClienteModel;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ClienteRequest(
		
		@JsonProperty("nome")
		@NotNull
		@NotBlank
		String nome,
		
		@JsonProperty("email")
		@NotNull
		@Email
		String email		
		) {
	
    public static ClienteModel toModel(ClienteRequest input) {
        return new ClienteModel(
                input.nome,
                input.email
       );
    }
}
