package org.edu.unidep.domain.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.edu.unidep.api.dto.assembler.TransferenciaOutputAssembler;
import org.edu.unidep.api.dto.model.TransferenciaModel;
import org.edu.unidep.domain.filter.TransferenciaFilter;
import org.edu.unidep.domain.repository.TransferenciaRepository;

@ApplicationScoped
public class TransferenciaService {

	@Inject
	private TransferenciaRepository transferenciaRepository;
	
	@Inject
	private TransferenciaOutputAssembler transferenciaOutputAssembler;
	
	public List<TransferenciaModel> transferenciaUsandoFiltro(TransferenciaFilter filter){
		return transferenciaOutputAssembler.toCollectionModel(
				transferenciaRepository.getWithFilter(filter));
	}
}
