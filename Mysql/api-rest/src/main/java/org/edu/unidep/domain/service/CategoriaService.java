package org.edu.unidep.domain.service;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

import org.edu.unidep.api.rest.request.CategoriaRequest;
import org.edu.unidep.domain.model.Categoria;
import org.edu.unidep.domain.repository.CategoriaRepository;

@ApplicationScoped
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;

    @Inject
    public CategoriaService(
            CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    /*
    * Categoria categoria
    *   Codigo    Nome
    *     1       Entrada Autorizada
    */

    @Transactional
    public Categoria atualizar(Long id, CategoriaRequest request) {
        Categoria categoriaEncontrada =
                categoriaRepository
                        .listarCategoriaPeloCodigo(id);

        /*
         * Categoria categoriaEncontrada
         *   Codigo    Nome
         *     1       Entrada
         */
        categoriaEncontrada.setNome(request.nome());
        // "Entrada".setNome("Entrada Autorizada");

        return categoriaEncontrada;
    }

}
