package org.edu.unidep.domain.repository.onetomany;

import java.util.List;
import java.util.Optional;

import org.edu.unidep.domain.model.onetomany.Cidade;

public interface CidadeRepository {
	List<Cidade> listarCidades();
	Optional<Cidade> buscarCidadePorId(Long id);
	void salvar(Cidade cidade);
	void excluir(Cidade cidade);
}
