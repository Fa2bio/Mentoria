package org.edu.unidep.api.controller;

import java.time.LocalDate;
import java.util.List;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.edu.unidep.api.dto.assembler.PedidoAssembler;
import org.edu.unidep.api.dto.model.PedidoModel;
import org.edu.unidep.api.dto.request.PedidoRequest;
import org.edu.unidep.api.dto.response.PedidoResponse;
import org.edu.unidep.domain.model.Pedido;
import org.edu.unidep.domain.service.PedidoService;

@Path("/pedidos")
public class PedidoController {

	@Inject
	private PedidoService pedidoService;
	
	@Inject
	private PedidoAssembler pedidoAssembler;
	
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response listarTodos() {
    	List<Pedido> pedidos = pedidoService.listar();
    	if(pedidos.isEmpty()) return Response.status(Status.NO_CONTENT).build();
        return Response.ok(pedidoAssembler.toCollectionResponse(pedidos)).build();
    }
    
    @GET
    @Path("/listarpeladata/{data}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listarTodosPelaData(@PathParam("data") String data) {
    	LocalDate localDate = LocalDate.parse(data);
    	List<Pedido> pedidos = pedidoService.listarPelaData(localDate);
    	if(pedidos.isEmpty()) return Response.status(Status.NO_CONTENT).build();
        return Response.ok(pedidoAssembler.toCollectionResponse(pedidos)).build();

    }
    
    @GET
    @Path("/listarpelonome/{nome}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listarTodosPeloNome(@PathParam("nome") String nome) {
    	List<Pedido> pedidos = pedidoService.listarPeloNomeCliente(nome);
    	if(pedidos.isEmpty()) return Response.status(Status.NO_CONTENT).build();
        return Response.ok(pedidoAssembler.toCollectionResponse(pedidos)).build();
    }
    
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public PedidoResponse buscarPedido(
			@PathParam("id") Long id) {		
		Pedido pedidoEncontrado = pedidoService.buscarPorCodigo(id);
		PedidoResponse pedidoResponse = pedidoAssembler.toResponse(pedidoEncontrado);
		return pedidoResponse;		
	}
	
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response salvar(@RequestBody @Valid PedidoRequest pedidoInput) {
    	PedidoModel pedidoModel = PedidoRequest.toModel(pedidoInput);
    	pedidoService.salvar(pedidoModel);
        return Response.status(Status.CREATED).build();
    }
}
