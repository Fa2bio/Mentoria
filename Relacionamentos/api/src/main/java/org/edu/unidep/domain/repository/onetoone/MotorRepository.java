package org.edu.unidep.domain.repository.onetoone;

import java.util.List;
import java.util.Optional;

import org.edu.unidep.domain.model.onetoone.Motor;

public interface MotorRepository {
	List<Motor> listarMotor();
	Optional<Motor> buscarMotorPorId(Long id);
	void salvar(Motor motor);
	void excluir(Motor motor);
}
