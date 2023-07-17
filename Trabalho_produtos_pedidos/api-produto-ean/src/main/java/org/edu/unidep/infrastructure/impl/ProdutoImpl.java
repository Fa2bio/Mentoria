package org.edu.unidep.infrastructure.impl;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

import org.edu.unidep.domain.model.Produto;
import org.edu.unidep.domain.repository.ProdutoRepository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class ProdutoImpl implements PanacheRepository<Produto>,
	ProdutoRepository{

	@Override
	public List<Produto> listarTodos() {
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

	@Override
	@Transactional
	public void criar(Produto produto) {
		persist(produto);		
	}

	@Override
	@Transactional
	public void deleter(Produto produto) {
		delete(produto);
		getEntityManager().flush();
	}

}
