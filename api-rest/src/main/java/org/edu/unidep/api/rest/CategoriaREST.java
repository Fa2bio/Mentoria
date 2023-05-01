package org.edu.unidep.api.rest;

import java.util.List;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.edu.unidep.api.command.CategoriaCommand;
import org.edu.unidep.api.rest.request.CategoriaRequest;
import org.edu.unidep.api.rest.response.CategoriaResponse;
import org.edu.unidep.domain.repository.CategoriaRepository;
import org.edu.unidep.domain.service.CategoriaService;

// 192.168.8.70:8080/api/categoria

@Path("/categoria")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CategoriaREST {

    private final CategoriaRepository categoriaRepository;

    private final CategoriaService categoriaService;

    @Inject
    public CategoriaREST(
            CategoriaRepository categoriaRepository,
            CategoriaService categoriaService) {
        this.categoriaRepository = categoriaRepository;
        this.categoriaService = categoriaService;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response listarCategorias() {

        List<CategoriaResponse> responses = categoriaRepository.
                listarCategorias()
                .stream()
                .map(categoria ->
                    new CategoriaResponse(categoria.getNome())
                )
                .toList();

        return Response.ok(responses).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listarCategoriaPeloCodigo(
            @PathParam("id") Long id) {

        CategoriaResponse response = CategoriaResponse.toResponse(
                categoriaRepository.listarCategoriaPeloCodigo(id)
        );

        return Response.ok(response).build();
    }

    @APIResponse(
            responseCode = "204", description = "Salvar categoria",
            content = @Content(mediaType = "application/json",
                    schema = @Schema(type = SchemaType.OBJECT,
                            implementation = CategoriaRequest.class))
    )
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public void salvar(@RequestBody @Valid CategoriaRequest request) {

        CategoriaCommand categoriaCommand = CategoriaRequest.toCommand(request);

        categoriaRepository.salvar(categoriaCommand);
    }

    @PUT
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response atualizar(
            @PathParam("id") Long id,
            @RequestBody CategoriaRequest request) {

        return Response.ok(categoriaService.atualizar(id, request)).build();
    }
}
