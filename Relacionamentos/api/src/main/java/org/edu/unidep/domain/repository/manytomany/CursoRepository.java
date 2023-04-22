package org.edu.unidep.domain.repository.manytomany;

import java.util.List;
import java.util.Optional;

import org.edu.unidep.domain.model.manytomany.Curso;

public interface CursoRepository {
	List<Curso> listarCursos();
	Optional<Curso> buscarCursoPorId(Long id);
	void salvar(Curso curso);
	void excluir(Curso curso);
}
