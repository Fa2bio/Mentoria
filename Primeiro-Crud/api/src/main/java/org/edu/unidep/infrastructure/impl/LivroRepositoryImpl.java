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
	public Optional<Livro> buscarLivroPorIsbn10(String isbn) {
		String jpql = """
				SELECT l FROM Livro l WHERE l.volumeInfo.isbn10 = :isbn
				""";
		return getEntityManager()
				.createQuery(jpql, Livro.class)
				.setParameter("isbn", isbn)
				.getResultStream()
				.findFirst();
	}

	@Override
	public Optional<Livro> buscarLivroPorIsbn13(String isbn) {
		String jpql = """
				SELECT l FROM Livro l WHERE l.volumeInfo.isbn13 = :isbn
				""";
		return getEntityManager()
				.createQuery(jpql, Livro.class)
				.setParameter("isbn", isbn)
				.getResultStream()
				.findFirst();
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
