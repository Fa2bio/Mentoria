package org.edu.unidep.domain.repository;

import java.util.List;
import java.util.Optional;

import org.edu.unidep.domain.model.Funcionario;

public interface FuncionarioRepository {
	List<Funcionario> listar();
	Optional<Funcionario> buscarPorId(Long id);
	void salvar(Funcionario funcionario);
	void deletar(Funcionario funcionario);
}
