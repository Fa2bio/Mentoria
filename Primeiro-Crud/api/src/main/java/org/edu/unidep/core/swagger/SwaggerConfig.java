package org.edu.unidep.core.swagger;

import javax.ws.rs.core.Application;

import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.info.Contact;
import org.eclipse.microprofile.openapi.annotations.info.Info;
import org.eclipse.microprofile.openapi.annotations.info.License;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;


@OpenAPIDefinition(
		tags = {
				@Tag(name = "Cliente", description = "Gerencia a Entidade Cliente"),
				@Tag(name = "Funcionario", description = "Gerencia a Entidade Funcionario"),
				@Tag(name = "Livro", description = "Gerencia a Entidade Livro"),
				@Tag(name = "Pedido", description = "Gerencia a Entidade Pedido")
		},
		info = @Info(
				title = "Library-API",
				version = "1.0.0",
				contact = @Contact(
						name = "Fábio",
						url = "www.github.com/Fa2bio",
						email = "fabio.s0@hotmail.com"
				),
				license = @License(
						name = "Apache 2.0",
						url = "https://www.apache.org/licenses/LICENSE-2.0.html"
				)
				
		)		
)
public class SwaggerConfig extends Application{

}
