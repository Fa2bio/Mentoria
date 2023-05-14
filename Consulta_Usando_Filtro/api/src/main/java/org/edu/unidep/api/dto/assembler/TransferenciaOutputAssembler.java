package org.edu.unidep.api.dto.assembler;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.edu.unidep.api.dto.model.TransferenciaModel;
import org.edu.unidep.domain.model.Transferencia;
import org.modelmapper.ModelMapper;

@ApplicationScoped
public class TransferenciaOutputAssembler {

	@Inject
	private ModelMapper modelMapper;
	
	public TransferenciaModel toModel(Transferencia transferencia) {
		return modelMapper.map(transferencia, TransferenciaModel.class);
	}
	
	public List<TransferenciaModel> toCollectionModel(List<Transferencia> transferencias){
		List<TransferenciaModel> transferenciasModel = new ArrayList<>();
		for(Transferencia transferencia : transferencias) {
			transferenciasModel.add(toModel(transferencia));
		}
		
		return transferenciasModel;
	}
}
