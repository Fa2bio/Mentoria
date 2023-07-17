package org.edu.unidep.infrastructure.impl.manytomany;

import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

import org.edu.unidep.domain.model.manytomany.Curso;
import org.edu.unidep.domain.repository.manytomany.CursoRepository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class CursoRepositoryImpl implements CursoRepository,
	PanacheRepository<Curso>{

	@Override
	public List<Curso> listarCursos() {
		return listAll();
	}

	@Override
	public Optional<Curso> buscarCursoPorId(Long id) {
		return findByIdOptional(id);
	}

	@Override
	@Transactional
	public void salvar(Curso curso) {
		persist(curso);
	}

	@Override
	@Transactional
	public void excluir(Curso curso) {
		delete(curso);
	}

}
