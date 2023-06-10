package org.edu.unidep.domain.repository;

import java.util.List;

import org.edu.unidep.domain.model.Produto;

public interface ProdutoRepository {

    List<Produto> listar();

    Produto listarProdutoPeloCodigo(Long id);

    void salvar(Produto produto);

    void deletar(Produto produto);

}
