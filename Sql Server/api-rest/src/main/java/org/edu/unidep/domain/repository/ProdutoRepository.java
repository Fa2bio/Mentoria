package org.edu.unidep.domain.repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.edu.unidep.domain.model.Produto;

public interface ProdutoRepository {

    List<Produto> listar();

    Optional<Produto> listarProdutoPeloCodigo(Long id);

    Optional<BigDecimal> retornarQuantidadeTotalProdutoEDataEmUnidadeMedida(Long codigoProduto, LocalDate dataInicio, LocalDate dataFim);

    Optional<BigDecimal> retornarQuantidadeTotalEmReais(Long codigoProduto, LocalDate dataInicio, LocalDate dataFim);
    
    void salvar(Produto produto);

    void deletar(Produto produto);

}
