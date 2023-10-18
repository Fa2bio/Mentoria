package org.edu.unidep.api.hypermedia;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.core.Link;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import org.edu.unidep.api.controller.ClienteController;
import org.edu.unidep.api.controller.FuncionarioController;
import org.edu.unidep.api.controller.LivroController;
import org.edu.unidep.api.controller.PedidoController;

@ApplicationScoped
public class ApiLinks {
	
	/*Links Para o Controller De Cliente*/
	public Link linkToClientesListar(UriInfo uriInfo) {		
		String uri = uriWithMethod(uriInfo, ClienteController.class, "listarTodos");		
		Link link = linkBuilder(uri, "_blank","GET");
		return link;
	}

	public Link linkToClientesBuscar(Long clienteId, UriInfo uriInfo) {
		String uri = uriWithMethod(uriInfo, ClienteController.class, clienteId, "buscarCliente");		
		Link link = linkBuilder(uri, "_self", "GET");
		return link;
	}
	
	public Link linkToClientesAtualizar(Long clienteId, UriInfo uriInfo) {
		String uri = uriWithMethod(uriInfo, ClienteController.class, clienteId, "atualizarCliente");		
		Link link = linkBuilder(uri, "_self", "PUT");
		return link;
	}
	
	public Link linkToClientesRegistrar(UriInfo uriInfo) {
		String uri = uriWithMethod(uriInfo, ClienteController.class, "registrar");		
		Link link = linkBuilder(uri, "_blank", "POST");
		return link;
	}
	
	public Link linkToClientesExcluir(Long clienteId, UriInfo uriInfo) {
		String uri = uriWithMethod(uriInfo, ClienteController.class, clienteId, "excluir");		
		Link link = linkBuilder(uri, "_self", "DELETE");
		return link;
	}
	/*******************************************************************************************************/
	
	/*Links Para o Controller De Funcionario*/
	public Link linkToFuncionariosListar(UriInfo uriInfo) {		
		String uri = uriWithMethod(uriInfo, FuncionarioController.class, "listarTodos");		
		Link link = linkBuilder(uri, "_blank","GET");
		return link;
	}
	
	public Link linkToFuncionariosBuscar(Long funcionarioId, UriInfo uriInfo) {
		String uri = uriWithMethod(uriInfo, FuncionarioController.class, funcionarioId, "buscarFuncionario");		
		Link link = linkBuilder(uri, "_self", "GET");
		return link;
	}
	
	public Link linkToFuncionariosAtualizar(Long funcionarioId, UriInfo uriInfo) {
		String uri = uriWithMethod(uriInfo, FuncionarioController.class, funcionarioId, "atualizarFuncionario");		
		Link link = linkBuilder(uri, "_self", "PUT");
		return link;
	}
	
	public Link linkToFuncionariosRegistrar(UriInfo uriInfo) {
		String uri = uriWithMethod(uriInfo, FuncionarioController.class, "registrar");		
		Link link = linkBuilder(uri, "_blank", "POST");
		return link;
	}
	
	public Link linkToFuncionariosExcluir(Long funcionarioId, UriInfo uriInfo) {
		String uri = uriWithMethod(uriInfo, FuncionarioController.class, funcionarioId, "excluir");		
		Link link = linkBuilder(uri, "_self", "DELETE");
		return link;
	}
	/*******************************************************************************************************/
	
	/*Links Para o Controller De Livro*/
	public Link linkToLivrosListar(UriInfo uriInfo) {		
		String uri = uriWithMethod(uriInfo, LivroController.class, "listarTodos");		
		Link link = linkBuilder(uri, "_blank","GET");
		return link;
	}
	
	public Link linkToLivrosBuscar(Long livroId, UriInfo uriInfo) {
		String uri = uriWithMethod(uriInfo, LivroController.class, livroId, "buscarLivro");		
		Link link = linkBuilder(uri, "_self", "GET");
		return link;
	}
	
	public Link linkToLivrosBuscarPorIsbn(String isbn, UriInfo uriInfo) {
		String uri = uriWithMethod(uriInfo, LivroController.class, isbn, "buscarLivroPorIsbn");		
		Link link = linkBuilder(uri, "_self", "GET");
		return link;
	}
	
	public Link linkToLivrosAtualizar(Long livroId, UriInfo uriInfo) {
		String uri = uriWithMethod(uriInfo, LivroController.class, livroId, "atualizarLivro");		
		Link link = linkBuilder(uri, "_self", "PUT");
		return link;
	}
	
	public Link linkToLivrosRegistrar(UriInfo uriInfo) {
		String uri = uriWithMethod(uriInfo, LivroController.class, "registrar");		
		Link link = linkBuilder(uri, "_blank", "POST");
		return link;
	}
	
	public Link linkToLivrosExcluir(Long livroId, UriInfo uriInfo) {
		String uri = uriWithMethod(uriInfo, LivroController.class, livroId, "excluir");		
		Link link = linkBuilder(uri, "_self", "DELETE");
		return link;
	}
	/*******************************************************************************************************/
	
	/*Links Para o Controller De Livro*/
	public Link linkToPedidosListar(UriInfo uriInfo) {		
		String uri = uriWithMethod(uriInfo, PedidoController.class, "listarTodos");		
		Link link = linkBuilder(uri, "_blank","GET");
		return link;
	}
	
	public Link linkToPedidosListarData(String data, UriInfo uriInfo) {
		String uri = uriWithDataMethod(uriInfo, PedidoController.class, data, "listarPelaData");		
		Link link = linkBuilder(uri, "_self", "GET");
		return link;
	}
	
	public Link linkToPedidosListarNomeCliente(String nome, UriInfo uriInfo) {
		String uri = uriWithNomeMethod(uriInfo, PedidoController.class, nome, "listarPeloNomeCliente");		
		Link link = linkBuilder(uri, "_self", "GET");
		return link;
	}
	
	public Link linkToPedidosListarNomeFuncionario(String nome, UriInfo uriInfo) {
		String uri = uriWithNomeMethod(uriInfo, PedidoController.class, nome, "listarPeloNomeFuncionario");		
		Link link = linkBuilder(uri, "_self", "GET");
		return link;
	}
	
	public Link linkToPedidosListarComFiltro(UriInfo uriInfo) {		
		String uri = uriWithMethod(uriInfo, PedidoController.class, "listarComFiltro");		
		Link link = linkBuilder(uri, "_blank","GET");
		return link;
	}
	
	public Link linkToPedidosBuscar(Long pedidoId, UriInfo uriInfo) {
		String uri = uriWithMethod(uriInfo, PedidoController.class, pedidoId, "buscarPedido");		
		Link link = linkBuilder(uri, "_self", "GET");
		return link;
	}
	
	public Link linkToPedidosBuscarPorCodigo(String codigo, UriInfo uriInfo) {
		String uri = uriWithCodigoMethod(uriInfo, PedidoController.class, codigo, "buscarPedidoPeloCodigo");		
		Link link = linkBuilder(uri, "_self", "GET");
		return link;
	}
	
	public Link linkToPedidoRegistrar(UriInfo uriInfo) {
		String uri = uriWithMethod(uriInfo, PedidoController.class, "registrar");		
		Link link = linkBuilder(uri, "_blank", "POST");
		return link;
	}
	/*******************************************************************************************************/
	
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
	
	private String uriWithMethod(UriInfo uriInfo, Class<?> classs, Long id, String method) {
		String uri = uriInfo.getBaseUriBuilder()
				.path(classs)
				.path(classs, method)
				.resolveTemplate("id", id)
				.build()
				.toString();
		return uri;
	}
	
	private String uriWithMethod(UriInfo uriInfo, Class<?> classs, String isbn, String method) {
		String uri = uriInfo.getBaseUriBuilder()
				.path(classs)
				.path(classs, method)
				.resolveTemplate("isbn", isbn)
				.build()
				.toString();
		return uri;
	}
	
	private String uriWithDataMethod(UriInfo uriInfo, Class<?> classs, String data, String method) {
		String uri = uriInfo.getBaseUriBuilder()
				.path(classs)
				.path(classs, method)
				.resolveTemplate("data", data)
				.build()
				.toString();
		return uri;
	}
	
	private String uriWithNomeMethod(UriInfo uriInfo, Class<?> classs, String nome, String method) {
		String uri = uriInfo.getBaseUriBuilder()
				.path(classs)
				.path(classs, method)
				.resolveTemplate("nome", nome)
				.build()
				.toString();
		return uri;
	}
	
	private String uriWithCodigoMethod(UriInfo uriInfo, Class<?> classs, String codigo, String method) {
		String uri = uriInfo.getBaseUriBuilder()
				.path(classs)
				.path(classs, method)
				.resolveTemplate("codigo", codigo)
				.build()
				.toString();
		return uri;
	}
}
