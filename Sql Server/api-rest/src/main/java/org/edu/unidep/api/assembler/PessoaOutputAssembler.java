package org.edu.unidep.api.assembler;

import java.util.List;
import java.util.stream.Collectors;

import javax.enterprise.context.ApplicationScoped;

import org.edu.unidep.api.rest.response.PessoaResponse;
import org.edu.unidep.domain.model.Pessoa;

@ApplicationScoped
public class PessoaOutputAssembler {
	
	public PessoaResponse toResponse(Pessoa pessoa) {
		return new PessoaResponse(
				pessoa.getId(),
				pessoa.getNome(),
				pessoa.getDataAniversario(),
				pessoa.getTipoSanguineo(),
				pessoa.getEndereco(),
				pessoa.getCpf()
		);
	}

	public List<PessoaResponse> toCollectionResponse(List<Pessoa> pessoas){		
		return pessoas.stream()
				.map(pessoa -> toResponse(pessoa))
				.collect(Collectors.toList());
	}
}
