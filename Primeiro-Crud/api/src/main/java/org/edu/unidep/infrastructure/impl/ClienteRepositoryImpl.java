package org.edu.unidep.infrastructure.impl;

import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

import org.edu.unidep.domain.model.Cliente;
import org.edu.unidep.domain.repository.ClienteRepository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class ClienteRepositoryImpl implements ClienteRepository, 
PanacheRepository<Cliente>{

	@Override
	public List<Cliente> listar() {
		return listAll();
	}

	@Override
	public Optional<Cliente> buscarPorId(Long id) {
		return findByIdOptional(id);
	}

	@Override
	@Transactional
	public void salvar(Cliente cliente) {
		persist(cliente);
	}

	@Override
	@Transactional
	public void deletar(Cliente cliente) {
		delete(cliente);
		getEntityManager().flush();
	}

}
