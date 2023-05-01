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
    public BigDecimal retornarQuantidadeTotalProdutoEDataEmUnidadeMedida(
            Long codigoProduto
    ) {

        String jpql = """
                    SELECT SUM(v.quantidade) FROM Venda v
                        JOIN v.produto p WHERE p.id = :codigo 
                            AND v.data >= :primeiroDiaMesAtual
                            AND v.data <= :ultimoDiaMesAtual
                """;

        return getEntityManager()
                .createQuery(jpql, BigDecimal.class)
                .setParameter("codigo", codigoProduto)
                .setParameter("primeiroDiaMesAtual", retonarPrimeiroDiaDoMesAtual())
                .setParameter("ultimoDiaMesAtual", retonarUltimoDiaDoMesAtual())
                .getResultStream()
                .findAny()
                .orElseThrow();
    }

    @Override
    public BigDecimal retornarQuantidadeTotalEmReais(Long codigoProduto) {
        String jpql = """
                    SELECT SUM(v.valorTotal) FROM Venda v
                        JOIN v.produto p WHERE p.id = :codigo
                            AND v.data >= :primeiroDiaMesAtual
                            AND v.data <= :ultimoDiaMesAtual
                        
                """;

        return getEntityManager()
                .createQuery(jpql, BigDecimal.class)
                .setParameter("codigo", codigoProduto)
                .setParameter("primeiroDiaMesAtual", retonarPrimeiroDiaDoMesAtual())
                .setParameter("ultimoDiaMesAtual", retonarUltimoDiaDoMesAtual())
                .getResultStream()
                .findAny()
                .orElseThrow();
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

    private LocalDate retonarPrimeiroDiaDoMesAtual() {
        return LocalDate.now();
    }

    private LocalDate retonarUltimoDiaDoMesAtual() {
        return LocalDate.now();
    }

}
