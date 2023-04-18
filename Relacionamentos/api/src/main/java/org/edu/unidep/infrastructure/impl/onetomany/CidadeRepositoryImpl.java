package org.edu.unidep.infrastructure.impl.onetomany;

import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

import org.edu.unidep.domain.model.onetomany.Cidade;
import org.edu.unidep.domain.repository.onetomany.CidadeRepository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class CidadeRepositoryImpl implements CidadeRepository,
	PanacheRepository<Cidade>{

	@Override
	public List<Cidade> listarCidades() {
		return listAll();
	}

	@Override
	public Optional<Cidade> buscarCidadePorId(Long id) {
		return findByIdOptional(id);
	}

	@Override
	@Transactional
	public void salvar(Cidade cidade) {
		persist(cidade);
	}

	@Override
	@Transactional
	public void excluir(Cidade cidade) {
		delete(cidade);
	}

}
