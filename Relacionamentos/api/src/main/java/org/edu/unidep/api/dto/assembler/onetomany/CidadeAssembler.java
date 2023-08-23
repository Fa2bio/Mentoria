package org.edu.unidep.api.dto.assembler.onetomany;

import java.util.List;
import java.util.stream.Collectors;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.edu.unidep.api.dto.model.onetomany.response.CidadeResponse;
import org.edu.unidep.api.dto.model.onetomany.response.CidadeResumoResponse;
import org.edu.unidep.domain.model.onetomany.Cidade;

@ApplicationScoped
public class CidadeAssembler {
	
	@Inject
	private EstadoAssembler estadoAssembler;
	
	public CidadeResponse toResponse(Cidade cidade) {
		return new CidadeResponse(
				cidade.getId(),
				cidade.getNome(),
				estadoAssembler.toResumoResponse(cidade.getEstado())
				);
	}

	public CidadeResumoResponse toResumoResponse(Cidade cidade) {
		return new CidadeResumoResponse(
				cidade.getId(),
				cidade.getNome()				
				);
	}
	
	public List<CidadeResponse> toCollectionResponse(List<Cidade> cidades){		
		return cidades.stream()
				.map(cidade -> toResponse(cidade))
				.collect(Collectors.toList());
	}
	
	public List<CidadeResumoResponse> toCollectionResumoResponse(List<Cidade> cidades){		
		return cidades.stream()
				.map(cidade -> toResumoResponse(cidade))
				.collect(Collectors.toList());
	}
	

}
