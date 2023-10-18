package org.edu.unidep.infrastructure.impl;

import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

import org.edu.unidep.domain.model.Funcionario;
import org.edu.unidep.domain.repository.FuncionarioRepository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class FuncionarioRepositoryImpl implements FuncionarioRepository,
PanacheRepository<Funcionario>{


	@Override
	public List<Funcionario> listar() {
		return listAll();
	}

	@Override
	public Optional<Funcionario> buscarPorId(Long id) {
		return findByIdOptional(id);
	}

	@Override
	@Transactional
	public void salvar(Funcionario funcionario) {
		persist(funcionario);
	}

	@Override
	@Transactional
	public void deletar(Funcionario funcionario) {
		delete(funcionario);		
	}
}
