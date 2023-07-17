package org.edu.unidep.domain.service.onetoone;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

import org.edu.unidep.domain.exception.onetoone.CarroNaoEncontradoException;
import org.edu.unidep.domain.model.onetoone.Carro;
import org.edu.unidep.domain.model.onetoone.Motor;
import org.edu.unidep.domain.repository.onetoone.CarroRepository;

@ApplicationScoped
public class CarroService {

	@Inject
	private CarroRepository carroRepository;
	
	@Inject
	private MotorService motorService;
	
	@Transactional
	public void registrar(Carro carro) {
		Motor motor = motorService.acharOuFalhar(carro.getMotor().getId());
		motor.setCarro(carro);
		carro.setMotor(motor);
		carroRepository.salvar(carro);
	}
	
	@Transactional
	public void excluirCarro(Long id) {		
		Carro carro = acharOuFalhar(id);
		carroRepository.excluir(carro);
	}
	
	public Carro acharOuFalhar(Long id) {
		return carroRepository.buscarCarroPorId(id)
				.orElseThrow(()-> new CarroNaoEncontradoException(id));
	}
}
