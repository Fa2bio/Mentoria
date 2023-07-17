package org.edu.unidep.infrastructure.impl.onetoone;

import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;

import org.edu.unidep.domain.model.onetoone.Motor;
import org.edu.unidep.domain.repository.onetoone.MotorRepository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class MotorRepositoryImpl implements MotorRepository,
	PanacheRepository<Motor>{

	@Override
	public List<Motor> listarMotor() {
		return listAll();
	}

	@Override
	public Optional<Motor> buscarMotorPorId(Long id) {
		return findByIdOptional(id);
	}

	@Override
	public void salvar(Motor motor) {
		persist(motor);
	}

	@Override
	public void excluir(Motor motor) {
		delete(motor);
		getEntityManager().flush();
	}	
}
