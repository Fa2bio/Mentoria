package org.edu.unidep.domain.service.onetoone;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.PersistenceException;
import javax.transaction.Transactional;

import org.edu.unidep.domain.exception.onetoone.MotorEmUsoException;
import org.edu.unidep.domain.exception.onetoone.MotorNaoEncontradoException;
import org.edu.unidep.domain.model.onetoone.Motor;
import org.edu.unidep.domain.repository.onetoone.MotorRepository;

@ApplicationScoped
public class MotorService {

	@Inject
	private MotorRepository motorRepository;
	
	@Transactional
	public void registrar(Motor motor) {
		motorRepository.salvar(motor);
	}
	
	@Transactional
	public void excluirMotor(Long id) {
		try {
			Motor motor = acharOuFalhar(id);
			motorRepository.excluir(motor);
		} catch (PersistenceException e) {
			throw new MotorEmUsoException(id);
		}
	}
	
	public Motor acharOuFalhar(Long id) {
		return motorRepository.buscarMotorPorId(id)
				.orElseThrow(()-> new MotorNaoEncontradoException(id));
	}
}
