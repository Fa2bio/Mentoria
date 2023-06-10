package org.edu.unidep.infrastrucute.impl;

import java.util.List;

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
    public Produto listarProdutoPeloCodigo(Long id) {
        String jpql = """
                SELECT p FROM Produto p WHERE p.id = :codigo
            """;

    return getEntityManager()
            .createQuery(jpql, Produto.class)
            .setParameter("codigo", id)
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

}
