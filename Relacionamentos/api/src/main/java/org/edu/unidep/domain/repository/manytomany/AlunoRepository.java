package org.edu.unidep.domain.repository.manytomany;

import java.util.List;
import java.util.Optional;

import org.edu.unidep.domain.model.manytomany.Aluno;

public interface AlunoRepository {
	List<Aluno> listarAlunos();
	Optional<Aluno> buscarAlunoPorId(Long id);
	void salvar(Aluno aluno);
	void excluir(Aluno aluno);
}
