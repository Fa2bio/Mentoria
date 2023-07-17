package org.edu.unidep.domain.repository.onetomany;

import java.util.List;
import java.util.Optional;

import org.edu.unidep.domain.model.onetomany.Estado;

public interface EstadoRepository {
	List<Estado> listarEstados();
	Optional<Estado> buscarEstadoPorId(Long id);
	void salvar(Estado estado);
	void excluir(Estado estado);
}
