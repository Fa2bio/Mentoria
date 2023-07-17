package org.edu.unidep.infrastructure.impl.onetoone;

import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

import org.edu.unidep.domain.model.onetoone.Carro;
import org.edu.unidep.domain.repository.onetoone.CarroRepository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class CarroRepositoryImpl implements CarroRepository,
	PanacheRepository<Carro>{

	@Override
	public List<Carro> listarCarro() {
		return listAll();
	}

	@Override
	public Optional<Carro> buscarCarroPorId(Long id) {
		return findByIdOptional(id);
	}

	@Override
	@Transactional
	public void salvar(Carro carro) {
		persist(carro);
	}

	@Override
	@Transactional
	public void excluir(Carro carro) {
		delete(carro);
		getEntityManager().flush();
	}

}
