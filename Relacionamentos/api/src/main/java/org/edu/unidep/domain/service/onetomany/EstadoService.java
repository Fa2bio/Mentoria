package org.edu.unidep.domain.service.onetomany;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

import org.edu.unidep.domain.exception.onetomany.EstadoNaoEncontradoException;
import org.edu.unidep.domain.model.onetomany.Estado;
import org.edu.unidep.domain.repository.onetomany.EstadoRepository;

@ApplicationScoped
public class EstadoService {

	@Inject
	private EstadoRepository estadoRepository;
	
	@Transactional
	public void registrar(Estado estado) {
		estadoRepository.salvar(estado);
	}
	
	@Transactional
	public void excluirEstado(Long id) {		
		Estado Estado = acharOuFalhar(id);
		estadoRepository.excluir(Estado);
	}
	
	public Estado acharOuFalhar(Long id) {
		return estadoRepository.buscarEstadoPorId(id)
				.orElseThrow(()-> new EstadoNaoEncontradoException(id));
	}
}
