package org.edu.unidep.api.dto.assembler.onetomany;

import java.util.List;
import java.util.stream.Collectors;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.edu.unidep.api.dto.model.onetomany.response.EstadoResponse;
import org.edu.unidep.api.dto.model.onetomany.response.EstadoResumoResponse;
import org.edu.unidep.domain.model.onetomany.Estado;

@ApplicationScoped
public class EstadoAssembler {
	
	@Inject
	private CidadeAssembler cidadeAssembler;
	
	
	public EstadoResponse toResponse(Estado estado) {
		return new EstadoResponse(
				estado.getId(), 
				estado.getNome(),
				cidadeAssembler.toCollectionResumoResponse(estado.getCidades())
				);
	}

	public EstadoResumoResponse toResumoResponse(Estado estado) {
		return new EstadoResumoResponse(
				estado.getId(), 
				estado.getNome()
				);
	}
	
	public List<EstadoResponse> toCollectionResponse(List<Estado> estados){		
		return estados.stream()
				.map(estado -> toResponse(estado))
				.collect(Collectors.toList());
	}
	
	public List<EstadoResumoResponse> toCollectionResumoResponse(List<Estado> estados){		
		return estados.stream()
				.map(estado -> toResumoResponse(estado))
				.collect(Collectors.toList());
	}
}
