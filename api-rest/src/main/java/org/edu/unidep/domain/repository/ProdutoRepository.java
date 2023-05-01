package org.edu.unidep.domain.repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.edu.unidep.domain.model.Produto;

public interface ProdutoRepository {

    List<Produto> listar();

    Optional<Produto> listarProdutoPeloCodigo(Long id);

    BigDecimal retornarQuantidadeTotalProdutoEDataEmUnidadeMedida(Long codigoProduto);

    BigDecimal retornarQuantidadeTotalEmReais(Long codigoProduto);
    
    void salvar(Produto produto);

    void deletar(Produto produto);

}
