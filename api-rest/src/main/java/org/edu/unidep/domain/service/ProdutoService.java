package org.edu.unidep.domain.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.PersistenceException;
import javax.transaction.Transactional;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;

import org.edu.unidep.api.command.ProdutoCommand;
import org.edu.unidep.api.command.ProdutoQuery;
import org.edu.unidep.api.rest.request.ProdutoRequest;
import org.edu.unidep.domain.exception.ProdutoEmUsoException;
import org.edu.unidep.domain.exception.ProdutoNaoEncontradoException;
import org.edu.unidep.domain.model.Produto;
import org.edu.unidep.domain.repository.ProdutoRepository;

@ApplicationScoped
public class ProdutoService {

	@Inject
    private ProdutoRepository produtoRepository;

	@Inject
	private Validator validator;

    public List<Produto> listar() {
        return produtoRepository.listar();
    }
    
    @Transactional
    public void salvar(ProdutoCommand command){
        Produto produto = new Produto();
        produto.setDescricao(command.descricao());
        produto.setDataVencimento(command.dataVencimento());
        produto.setUnidadeMedida(command.unidadeMedida());

        produtoRepository.salvar(produto);
    }
    
    @Transactional
    public ProdutoCommand atualizar(Long id, ProdutoCommand command) {
        Produto produtoEncontrada = acharOuFalhar(id);
        produtoEncontrada.setDataVencimento(command.dataVencimento());
        produtoEncontrada.setDescricao(command.descricao());
        produtoEncontrada.setUnidadeMedida(command.unidadeMedida());
        return command;
    }
    
	@Transactional
	public void deletarProduto(Long id) {
		Produto produtoEncontrada = acharOuFalhar(id);
		try {
			produtoRepository.deletar(produtoEncontrada);
		} catch (PersistenceException e) {
			throw new ProdutoEmUsoException(id);
		}
	}
	public Produto acharOuFalhar(Long id) {
		return produtoRepository.listarProdutoPeloCodigo(id)
				.orElseThrow(()-> new ProdutoNaoEncontradoException(id));
	}
	
	public void validarProdutoRequest(ProdutoRequest produtoRequest) {
		Set<ConstraintViolation<ProdutoRequest>> constraintViolations = validator.validate(produtoRequest);
		if(constraintViolations.isEmpty()) return;
		else throw new ConstraintViolationException(constraintViolations);
	}
    
    public ProdutoQuery retornarProdutoComQuantidadeTotal(Long codigoProduto) {
        Produto produto =acharOuFalhar(codigoProduto);

        BigDecimal quantidadeTotal =
                produtoRepository.retornarQuantidadeTotalProdutoEDataEmUnidadeMedida(codigoProduto);


        return new ProdutoQuery(
                quantidadeTotal,
                LocalDate.now().getMonth(),
                produto.getUnidadeMedida());

    }

    public ProdutoQuery retornarQuantidadeTotalEmReais(Long codigoProduto) {
        Produto produto =acharOuFalhar(codigoProduto);

        BigDecimal quantidadeEmReais =
                produtoRepository.retornarQuantidadeTotalEmReais(codigoProduto);


        return new ProdutoQuery(
                quantidadeEmReais,
                LocalDate.now().getMonth(),
                produto.getUnidadeMedida());

    }


}
