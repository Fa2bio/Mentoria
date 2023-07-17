package org.edu.unidep.domain.repository;

import java.util.List;

import org.edu.unidep.domain.model.Cliente;

public interface ClienteRepository {

    List<Cliente> listar();

    Cliente listarClientePeloCodigo(Long id);

    void salvar(Cliente cliente);

    void deletar(Cliente cliente);
}
