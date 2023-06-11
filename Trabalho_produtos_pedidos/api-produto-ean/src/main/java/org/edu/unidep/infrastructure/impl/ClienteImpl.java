package org.edu.unidep.infrastructure.impl;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import org.edu.unidep.domain.model.Cliente;
import org.edu.unidep.domain.repository.ClienteRepository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class ClienteImpl implements PanacheRepository<Cliente>,
	ClienteRepository{

	@Override
	public List<Cliente> listar() {
		return listAll();
	}

	@Override
	public Cliente listarClientePeloCodigo(Long id) {
        String jpql = """
                SELECT c FROM Cliente c WHERE c.id = :codigo
            """;

    return getEntityManager()
            .createQuery(jpql, Cliente.class)
            .setParameter("codigo", id)
            .getResultStream()
            .findAny()
            .orElseThrow();
	}

	@Override
	public void salvar(Cliente cliente) {
		persist(cliente);		
	}

	@Override
	public void deletar(Cliente cliente) {
		delete(cliente);
		getEntityManager().flush();
	}
}
