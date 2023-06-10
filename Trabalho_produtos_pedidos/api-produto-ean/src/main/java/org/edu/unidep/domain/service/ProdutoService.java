package org.edu.unidep.domain.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

import org.edu.unidep.api.dto.model.ProdutoModel;
import org.edu.unidep.domain.model.Produto;
import org.edu.unidep.domain.repository.ProdutoRepository;

@ApplicationScoped
public class ProdutoService {

	@Inject
    private ProdutoRepository produtoRepository;

    public List<Produto> listar() {
        return produtoRepository.listar();
    }
    
    public Produto buscarPorCodigo(Long id) {
    	return produtoRepository.listarProdutoPeloCodigo(id);
    }
    
    @Transactional
    public void salvar(ProdutoModel produtoModel){
    	Produto produto = new Produto();
    	produto.setNome(produtoModel.nome());
    	produto.setCategoria(produtoModel.categoria());
    	produto.setCodigoEan(produtoModel.codigoEan());
    	produto.setDataValidade(produtoModel.dataValidade());
        produtoRepository.salvar(produto);
    }
    
    @Transactional
    public Produto atualizar(Long id, ProdutoModel produtoModel) {
        Produto produtoEncontrado = buscarPorCodigo(id);
        produtoEncontrado.setNome(produtoModel.nome());
        produtoEncontrado.setCategoria(produtoModel.categoria());
        produtoEncontrado.setCodigoEan(produtoModel.codigoEan());
        produtoEncontrado.setDataValidade(produtoModel.dataValidade());
        return produtoEncontrado;
    }
    
	@Transactional
	public void deletarProduto(Long id) {
		Produto produtoEncontrada = buscarPorCodigo(id);
		produtoRepository.deletar(produtoEncontrada);
	}


}
