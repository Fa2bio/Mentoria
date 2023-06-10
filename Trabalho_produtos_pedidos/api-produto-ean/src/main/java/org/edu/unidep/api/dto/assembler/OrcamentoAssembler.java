package org.edu.unidep.api.dto.assembler;

import java.util.List;
import java.util.stream.Collectors;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.edu.unidep.api.dto.response.OrcamentoResponse;
import org.edu.unidep.domain.model.Orcamento;

@ApplicationScoped
public class OrcamentoAssembler {
	
	@Inject
	private ItemAssembler itemAssembler;

	public OrcamentoResponse toResponse(Orcamento orcamento) {
		return new OrcamentoResponse(
				orcamento.getId(),
				orcamento.getData(),
				orcamento.getDataValidade(),
				orcamento.getValor(),
				itemAssembler.toCollectionResponse(orcamento.getItens())
		);
	}

	public List<OrcamentoResponse> toCollectionResponse(List<Orcamento> orcamentos){		
		return orcamentos.stream()
				.map(orcamento -> toResponse(orcamento))
				.collect(Collectors.toList());
	}
}
