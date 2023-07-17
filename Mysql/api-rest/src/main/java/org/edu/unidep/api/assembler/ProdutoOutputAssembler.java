package org.edu.unidep.api.assembler;

import java.util.List;
import java.util.stream.Collectors;

import javax.enterprise.context.ApplicationScoped;

import org.edu.unidep.api.rest.response.ProdutoResponse;
import org.edu.unidep.domain.model.Produto;

@ApplicationScoped
public class ProdutoOutputAssembler {
	
	public ProdutoResponse toResponse(Produto produto) {
		return new ProdutoResponse(
				produto.getId(),
				produto.getDescricao(),
				produto.getUnidadeMedida(),
				produto.getDataVencimento()
		);
	}

	public List<ProdutoResponse> toCollectionResponse(List<Produto> produtos){		
		return produtos.stream()
				.map(produto -> toResponse(produto))
				.collect(Collectors.toList());
	}
}
