package org.edu.unidep.infrastructure.impl;

import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

import org.edu.unidep.domain.model.Livro;
import org.edu.unidep.domain.repository.LivroRepository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class LivroRepositoryImpl implements LivroRepository, 
PanacheRepository<Livro>{


	@Override
	public List<Livro> listar() {
		return listAll();
	}

	@Override
	public Optional<Livro> buscarPorId(Long id) {
		return findByIdOptional(id);
	}

	@Override
	@Transactional
	public void salvar(Livro livro) {
		persist(livro);
	}

	@Override
	@Transactional
	public void deletar(Livro livro) {
		delete(livro);		
	}

}
