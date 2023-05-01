package org.edu.unidep.infrastrucute.impl;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

import org.edu.unidep.api.command.VendaCommand;
import org.edu.unidep.domain.model.Venda;
import org.edu.unidep.domain.repository.VendaRepository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class VendaImpl implements PanacheRepository<Venda>,
        VendaRepository {


    @Override
    public List<Venda> listarVendas() {
        return listAll();
    }

    @Override
    public Venda listarVendaPeloCodigo(Long id) {
        String jpql = """
                    SELECT v FROM Venda v WHERE v.id = :codigo
                """;

        return getEntityManager()
                .createQuery(jpql, Venda.class)
                .setParameter("codigo", id)
                .getResultStream()
                .findAny()
                .orElseThrow();
    }

    @Transactional
    @Override
    public void salvar(VendaCommand command) {
        Venda venda = new Venda();
        venda.setQuantidade(command.quantidade());
        venda.setValorTotal(command.valorTotal());
        venda.setUnidadeMedida(command.unidadeMedida());
        venda.setData(command.data());

        persist(venda);
    }
}
