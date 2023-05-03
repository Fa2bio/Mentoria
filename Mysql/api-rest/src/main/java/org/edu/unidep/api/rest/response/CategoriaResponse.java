package org.edu.unidep.api.rest.response;

import org.edu.unidep.domain.model.Categoria;

public record CategoriaResponse(String nome) {

    public static CategoriaResponse toResponse (Categoria categoria) {
        return new CategoriaResponse(categoria.getNome());
    }

}
