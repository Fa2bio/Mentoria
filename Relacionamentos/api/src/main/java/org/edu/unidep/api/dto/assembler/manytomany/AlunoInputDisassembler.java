package org.edu.unidep.api.dto.assembler.manytomany;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.edu.unidep.api.dto.model.manytomany.input.AlunoInputModel;
import org.edu.unidep.domain.model.manytomany.Aluno;
import org.modelmapper.ModelMapper;

@ApplicationScoped
public class AlunoInputDisassembler {

	@Inject
	private ModelMapper modelMapper;
	
	public Aluno toDomainObject (AlunoInputModel alunoInput) {
		return modelMapper.map(alunoInput, Aluno.class);
	}
}
