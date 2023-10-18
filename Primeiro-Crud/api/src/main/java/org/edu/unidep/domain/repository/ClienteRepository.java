package org.edu.unidep.domain.repository;

import java.util.List;
import java.util.Optional;

import org.edu.unidep.domain.model.Cliente;

public interface ClienteRepository {

	//CRUD - CREATE / READ / UPDATE / DELETE
	
	List<Cliente> listar();
	Optional<Cliente> buscarPorId(Long id);
	void salvar(Cliente cliente);
	void deletar(Cliente cliente);
}
