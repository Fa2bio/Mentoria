package org.edu.unidep.domain.repository;

import java.util.List;
import java.util.Optional;

import org.edu.unidep.domain.model.Livro;

public interface LivroRepository {
	List<Livro> listar();
	Optional<Livro> buscarPorId(Long id);
	void salvar(Livro livro);
	void deletar(Livro livro);
}
