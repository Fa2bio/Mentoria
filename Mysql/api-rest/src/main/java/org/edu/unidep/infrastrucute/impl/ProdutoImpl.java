package org.edu.unidep.infrastrucute.impl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

import org.edu.unidep.domain.model.Produto;
import org.edu.unidep.domain.repository.ProdutoRepository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class ProdutoImpl implements PanacheRepository<Produto>,
        ProdutoRepository {

    @Override
    public List<Produto> listar() {
        return listAll();
    }

    @Override
    public Optional<Produto> listarProdutoPeloCodigo(Long id) {
    	return findByIdOptional(id);
    }

	@Override
    public Optional<BigDecimal> retornarQuantidadeTotalProdutoEDataEmUnidadeMedida(
    		Long codigoProduto, LocalDate dataInicio, LocalDate dataFim) {

        String jpql = """
                    SELECT SUM(v.quantidade) FROM Venda v
                        JOIN v.produto p WHERE p.id = :codigo 
                            AND v.data >= :primeiroDiaMesAtual
                            AND v.data <= :ultimoDiaMesAtual
                """;
        
        return getEntityManager()
                .createQuery(jpql, BigDecimal.class)
                .setParameter("codigo", codigoProduto)
                .setParameter("primeiroDiaMesAtual", dataInicio)
                .setParameter("ultimoDiaMesAtual", dataFim)
                .getResultStream()
                .filter(i -> i != null)
                .findAny();
        
    }

    @Override
    public Optional<BigDecimal> retornarQuantidadeTotalEmReais(Long codigoProduto, LocalDate dataInicio, LocalDate dataFim) {
        String jpql = """
                    SELECT SUM(v.valorTotal) FROM Venda v
                        JOIN v.produto p WHERE p.id = :codigo
                            AND v.data >= :primeiroDiaMesAtual
                            AND v.data <= :ultimoDiaMesAtual
                        
                """;

        return getEntityManager()
                .createQuery(jpql, BigDecimal.class)
                .setParameter("codigo", codigoProduto)
                .setParameter("primeiroDiaMesAtual", dataInicio)
                .setParameter("ultimoDiaMesAtual", dataFim)
                .getResultStream()
                .filter(i -> i != null)
                .findAny();

    }
    
    @Transactional
    @Override
    public void salvar(Produto produto) {
        persist(produto);
    }
    
	@Override
	@Transactional
	public void deletar(Produto produto) {
		delete(produto);
		getEntityManager().flush();
	}
}
