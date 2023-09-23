package org.edu.unidep.api.hypermedia;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.core.Link;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import org.edu.unidep.api.controller.ClienteController;

@ApplicationScoped
public class ApiLinks {

	public Link linkToClientesListar(UriInfo uriInfo) {
		String uri = uriWithMethod(uriInfo, ClienteController.class, "listarTodos");
		Link link = linkBuilder(uri, "_blank", "GET");
		return link;
	}
	
	public Link linkToClientesBuscar(UriInfo uriInfo, Long clienteId) {
		String uri = uriWithIdMethod(uriInfo, ClienteController.class, "buscarCliente",clienteId);
		Link link = linkBuilder(uri, "_self", "GET");
		return link;
	}
	
	public Link linkToClientesAtualizar(UriInfo uriInfo, Long clienteId) {
		String uri = uriWithIdMethod(uriInfo, ClienteController.class, "atualizarCliente",clienteId);
		Link link = linkBuilder(uri, "_self", "PUT");
		return link;
	}
	
	public Link linkToClientesRegistrar(UriInfo uriInfo) {
		String uri = uriWithMethod(uriInfo, ClienteController.class, "registrar");
		Link link = linkBuilder(uri, "_blank", "POST");
		return link;
	}
	
	public Link linkToClientesExcluir(UriInfo uriInfo, Long clienteId) {
		String uri = uriWithIdMethod(uriInfo, ClienteController.class, "excluir",clienteId);
		Link link = linkBuilder(uri, "_self", "DELETE");
		return link;
	}
	
	private Link linkBuilder(String uri, String rel, String type) {
		return Link.fromUriBuilder(UriBuilder.fromUri(uri))
				.rel(rel)
				.type(type)
				.build();
	}
	
	private String uriWithMethod(UriInfo uriInfo, Class<?>classs, String method) {
		String uri = uriInfo.getBaseUriBuilder()
				.path(classs)
				.path(classs,method)
				.build()
				.toString();
		return uri;
	}
	
	private String uriWithIdMethod(UriInfo uriInfo, Class<?>classs, String method, Long id) {
		String uri = uriInfo.getBaseUriBuilder()
				.path(classs)
				.path(classs,method)
				.resolveTemplate("id", id)
				.build()
				.toString();
		return uri;
	}
}
