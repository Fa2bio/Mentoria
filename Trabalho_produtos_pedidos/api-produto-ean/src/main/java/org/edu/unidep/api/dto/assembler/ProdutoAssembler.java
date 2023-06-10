package org.edu.unidep.api.dto.assembler;

import java.util.List;
import java.util.stream.Collectors;

import javax.enterprise.context.ApplicationScoped;

import org.edu.unidep.api.dto.response.ProdutoResponse;
import org.edu.unidep.domain.model.Produto;

@ApplicationScoped
public class ProdutoAssembler {

	public ProdutoResponse toResponse(Produto produto) {
		return new ProdutoResponse(
				produto.getId(),
				produto.getNome(),
				produto.getCategoria(),
				produto.getCodigoEan(),
				produto.getDataValidade()
		);
	}

	public List<ProdutoResponse> toCollectionResponse(List<Produto> produtos){		
		return produtos.stream()
				.map(produto -> toResponse(produto))
				.collect(Collectors.toList());
	}
}
