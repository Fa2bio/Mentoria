package org.edu.unidep.api.dto.assembler.manytomany;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.edu.unidep.api.dto.model.manytomany.output.AlunoModel;
import org.edu.unidep.api.dto.model.manytomany.output.AlunoResumoModel;
import org.edu.unidep.domain.model.manytomany.Aluno;
import org.modelmapper.ModelMapper;

@ApplicationScoped
public class AlunoOutAssembler {

	@Inject
	private ModelMapper modelMapper;
	
	public AlunoModel toModel(Aluno aluno) {
		return modelMapper.map(aluno, AlunoModel.class);
	}
	
	public AlunoResumoModel toResumoModel(Aluno aluno) {
		return modelMapper.map(aluno, AlunoResumoModel.class);
	}
	
	public List<AlunoResumoModel> toCollectionModel(List<Aluno> alunos){
		List<AlunoResumoModel> alunoResumoModel = new ArrayList<>();
		for (Aluno aluno : alunos) {
			alunoResumoModel.add(toResumoModel(aluno));
		}
		return alunoResumoModel;
	}
}
