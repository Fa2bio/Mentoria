package org.edu.unidep.domain.repository;

import java.util.List;
import java.util.Optional;

import org.edu.unidep.domain.model.Pessoa;

public interface PessoaRepository {

    List<Pessoa> listarPessoas();

    Optional<Pessoa> listarPessoaPeloCodigo(Long id);

    void salvar(Pessoa pessoa);

    void deletar(Pessoa pessoa);
}
