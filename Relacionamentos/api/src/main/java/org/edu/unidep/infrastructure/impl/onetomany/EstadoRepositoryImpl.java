package org.edu.unidep.infrastructure.impl.onetomany;

import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

import org.edu.unidep.domain.model.onetomany.Estado;
import org.edu.unidep.domain.repository.onetomany.EstadoRepository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class EstadoRepositoryImpl implements EstadoRepository,
	PanacheRepository<Estado>{

	@Override
	public List<Estado> listarEstados() {
		return listAll();
	}

	@Override
	public Optional<Estado> buscarEstadoPorId(Long id) {
		return findByIdOptional(id);
	}

	@Override
	@Transactional
	public void salvar(Estado estado) {
		persist(estado);
	}

	@Override
	@Transactional
	public void excluir(Estado estado) {
		delete(estado);
	}

}
