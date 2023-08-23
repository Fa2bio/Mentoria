package org.edu.unidep.domain.service.onetomany;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

import org.edu.unidep.api.dto.model.onetomany.request.CidadeModel;
import org.edu.unidep.domain.exception.onetomany.CidadeNaoEncontradoException;
import org.edu.unidep.domain.model.onetomany.Cidade;
import org.edu.unidep.domain.model.onetomany.Estado;
import org.edu.unidep.domain.repository.onetomany.CidadeRepository;

@ApplicationScoped
public class CidadeService {

	@Inject
	private CidadeRepository cidadeRepository;
	
	@Inject
	private EstadoService estadoService;
	
	@Transactional
	public void registrar(CidadeModel cidadeModel) {
		Cidade cidade = new Cidade();
		cidade.setNome(cidadeModel.nome());
		Estado estado = estadoService.acharOuFalhar(cidadeModel.estadoId().id());
		cidade.setEstado(estado);
		cidadeRepository.salvar(cidade);
	}
	
	@Transactional
	public void excluirCidade(Long id) {		
		Cidade cidade = acharOuFalhar(id);
		cidadeRepository.excluir(cidade);
	}
	
	public Cidade acharOuFalhar(Long id) {
		return cidadeRepository.buscarCidadePorId(id)
				.orElseThrow(()-> new CidadeNaoEncontradoException(id));
	}
}
