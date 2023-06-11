package org.edu.unidep.domain.repository;

import java.util.List;

import org.edu.unidep.domain.model.Produto;

public interface ProdutoRepository {

	List<Produto> listarTodos();
	
	Produto listarProdutoPeloCodigo(Long id);
	
	void criar(Produto produto);
	
	void deleter(Produto produto);
}
