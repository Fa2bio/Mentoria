package org.edu.unidep.domain.repository;

import java.util.List;

import org.edu.unidep.api.command.CategoriaCommand;
import org.edu.unidep.domain.model.Categoria;

public interface CategoriaRepository {

    public List<Categoria> listarCategorias();

    Categoria listarCategoriaPeloCodigo(Long id);

    void salvar(CategoriaCommand command);

}
