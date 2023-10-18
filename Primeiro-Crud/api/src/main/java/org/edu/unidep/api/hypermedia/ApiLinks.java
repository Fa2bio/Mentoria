package org.edu.unidep.api.hypermedia;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.core.Link;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import org.edu.unidep.api.controller.ClienteController;
import org.edu.unidep.api.controller.FuncionarioController;
import org.edu.unidep.api.controller.LivroController;

@ApplicationScoped
public class ApiLinks {
	
	/*-----------------------------------Links Cliente Controller --------------------------------------------*/
	
	public Link linkToClientesListar(UriInfo uriInfo) {		
		String uri = uriWithMethod(uriInfo, ClienteController.class, "listarTodos");		
		Link link = linkBuilder(uri, "_blank","GET");
		return link;
	}

	public Link linkToClientesBuscar(UriInfo uriInfo, Long clienteId) {
		String uri = uriWithIdMethod(uriInfo, ClienteController.class, "buscarCliente", clienteId);		
		Link link = linkBuilder(uri, "_self", "GET");
		return link;
	}
	
	public Link linkToClientesAtualizar(UriInfo uriInfo, Long clienteId) {
		String uri = uriWithIdMethod(uriInfo, ClienteController.class, "atualizarCliente", clienteId);		
		Link link = linkBuilder(uri, "_self", "PUT");
		return link;
	}
	
	public Link linkToClientesRegistrar(UriInfo uriInfo) {
		String uri = uriWithMethod(uriInfo, ClienteController.class, "registrar");		
		Link link = linkBuilder(uri, "_blank", "POST");
		return link;
	}
	
	public Link linkToClientesExcluir(UriInfo uriInfo, Long clienteId) {
		String uri = uriWithIdMethod(uriInfo, ClienteController.class, "excluir", clienteId);		
		Link link = linkBuilder(uri, "_self", "DELETE");
		return link;
	}
	
	/*-----------------------------------Links Funcionario Controller --------------------------------------------*/
	
	public Link linkToFuncionariosListar(UriInfo uriInfo) {		
		String uri = uriWithMethod(uriInfo, FuncionarioController.class, "listarTodos");		
		Link link = linkBuilder(uri, "_blank","GET");
		return link;
	}
	
	public Link linkToFuncionariosBuscar(UriInfo uriInfo, Long funcionarioId) {
		String uri = uriWithIdMethod(uriInfo, FuncionarioController.class, "buscarFuncionario", funcionarioId);		
		Link link = linkBuilder(uri, "_self", "GET");
		return link;
	}
	
	public Link linkToFuncionariosAtualizar(UriInfo uriInfo, Long funcionarioId) {
		String uri = uriWithIdMethod(uriInfo, FuncionarioController.class, "atualizarFuncionario", funcionarioId);		
		Link link = linkBuilder(uri, "_self", "PUT");
		return link;
	}
	
	public Link linkToFuncionariosRegistrar(UriInfo uriInfo) {
		String uri = uriWithMethod(uriInfo, FuncionarioController.class, "registrar");		
		Link link = linkBuilder(uri, "_blank", "POST");
		return link;
	}
	
	public Link linkToFuncionariosExcluir(UriInfo uriInfo, Long funcionarioId) {
		String uri = uriWithIdMethod(uriInfo, FuncionarioController.class, "excluir", funcionarioId);		
		Link link = linkBuilder(uri, "_self", "DELETE");
		return link;
	}

	/*-----------------------------------Links Livros Controller --------------------------------------------*/
	
	public Link linkToLivrosListar(UriInfo uriInfo) {		
		String uri = uriWithMethod(uriInfo, LivroController.class, "listarTodos");		
		Link link = linkBuilder(uri, "_blank","GET");
		return link;
	}
	
	public Link linkToLivrosBuscar(UriInfo uriInfo, Long livroId) {
		String uri = uriWithIdMethod(uriInfo, LivroController.class, "buscarLivro", livroId);		
		Link link = linkBuilder(uri, "_self", "GET");
		return link;
	}
	
	public Link linkToLivrosBuscarPorIsbn(UriInfo uriInfo, String isbn) {
		String uri = uriWithIsbnMethod(uriInfo, LivroController.class, "buscarLivroPorIsbn", isbn);		
		Link link = linkBuilder(uri, "_self", "GET");
		return link;
	}
	
	public Link linkToLivrosAtualizar(UriInfo uriInfo, Long livroId) {
		String uri = uriWithIdMethod(uriInfo, LivroController.class, "atualizarLivro", livroId);		
		Link link = linkBuilder(uri, "_self", "PUT");
		return link;
	}
	
	public Link linkToLivrosRegistrar(UriInfo uriInfo) {
		String uri = uriWithMethod(uriInfo, LivroController.class, "registrar");		
		Link link = linkBuilder(uri, "_blank", "POST");
		return link;
	}
	
	public Link linkToLivrosExcluir(UriInfo uriInfo, Long livroId) {
		String uri = uriWithIdMethod(uriInfo, LivroController.class, "excluir", livroId);		
		Link link = linkBuilder(uri, "_self", "DELETE");
		return link;
	}

	private Link linkBuilder(String uri, String rel, String type) {
		return Link.fromUriBuilder(
				UriBuilder.fromUri(uri))
				.rel(rel)
				.type(type)
				.build();
	}
	
	private String uriWithMethod(UriInfo uriInfo, Class<?> classs, String method) {
		String uri = uriInfo.getBaseUriBuilder()
				.path(classs)
				.path(classs, method)
				.build()
				.toString();
		return uri;
	}
	
	private String uriWithIdMethod(UriInfo uriInfo, Class<?> classs, String method, Long id) {
		String uri = uriInfo.getBaseUriBuilder()
				.path(classs)
				.path(classs, method)
				.resolveTemplate("id", id)
				.build()
				.toString();
		return uri;
	}
	
	private String uriWithIsbnMethod(UriInfo uriInfo, Class<?> classs, String method, String isbn) {
		String uri = uriInfo.getBaseUriBuilder()
				.path(classs)
				.path(classs, method)
				.resolveTemplate("isbn", isbn)
				.build()
				.toString();
		return uri;
	}

}
