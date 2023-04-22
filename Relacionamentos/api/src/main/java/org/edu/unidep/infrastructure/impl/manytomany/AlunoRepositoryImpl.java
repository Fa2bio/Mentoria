package org.edu.unidep.infrastructure.impl.manytomany;

import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

import org.edu.unidep.domain.model.manytomany.Aluno;
import org.edu.unidep.domain.repository.manytomany.AlunoRepository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class AlunoRepositoryImpl implements AlunoRepository,
	PanacheRepository<Aluno>{

	@Override
	public List<Aluno> listarAlunos() {
		return listAll();
	}

	@Override
	public Optional<Aluno> buscarAlunoPorId(Long id) {
		return findByIdOptional(id);
	}

	@Override
	@Transactional
	public void salvar(Aluno aluno) {
		persist(aluno);
	}

	@Override
	@Transactional
	public void excluir(Aluno aluno) {
		delete(aluno);
	}

}
