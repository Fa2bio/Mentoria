package org.edu.unidep.domain.repository.onetoone;

import java.util.List;
import java.util.Optional;

import org.edu.unidep.domain.model.onetoone.Carro;

public interface CarroRepository {
	List<Carro> listarCarro();
	Optional<Carro> buscarCarroPorId(Long id);
	void salvar(Carro carro);
	void excluir(Carro carro);
}
