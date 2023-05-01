package org.edu.unidep.domain.service;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

import org.edu.unidep.api.command.VendaCommand;
import org.edu.unidep.domain.model.Venda;
import org.edu.unidep.domain.repository.VendaRepository;

@ApplicationScoped
public class VendaService {
    private final VendaRepository vendaRepository;

    @Inject
    public VendaService(
            VendaRepository vendaRepository) {
        this.vendaRepository = vendaRepository;
    }

    @Transactional
    public void salvar(VendaCommand command) {
        vendaRepository.salvar(command);
    }

    @Transactional
    public Venda atualizar(Long id, Venda venda) {
        Venda vendaEncontrada = vendaRepository.listarVendaPeloCodigo(id);

        vendaEncontrada.setQuantidade(venda.getQuantidade());
        vendaEncontrada.setValorTotal(venda.getValorTotal());
        vendaEncontrada.setUnidadeMedida(venda.getUnidadeMedida());
        vendaEncontrada.setData(venda.getData());

        return vendaEncontrada;
    }

}
