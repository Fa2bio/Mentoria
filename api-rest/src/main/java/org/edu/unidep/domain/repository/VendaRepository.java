package org.edu.unidep.domain.repository;

import java.util.List;

import org.edu.unidep.api.command.VendaCommand;
import org.edu.unidep.domain.model.Venda;

public interface VendaRepository {

    public List<Venda> listarVendas();

    Venda listarVendaPeloCodigo(Long id);

    void salvar(VendaCommand command);

}
