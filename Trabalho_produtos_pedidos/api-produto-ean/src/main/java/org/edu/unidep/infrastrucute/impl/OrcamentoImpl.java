package org.edu.unidep.infrastrucute.impl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import org.edu.unidep.domain.model.Orcamento;
import org.edu.unidep.domain.repository.OrcamentoRepository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class OrcamentoImpl implements PanacheRepository<Orcamento>,
	OrcamentoRepository{

	@Override
	public List<Orcamento> listar() {
		return listAll();
	}

	@Override
	public List<Orcamento> listarPelaData(LocalDate data) {
		String jpql = """
                SELECT o FROM Orcamento o WHERE o.data = :data
            """;

		return getEntityManager()
            .createQuery(jpql, Orcamento.class)
            .setParameter("data", data)
            .getResultStream()
            .toList();
	}

	@Override
	public List<Orcamento> listarPeloMaiorValor(BigDecimal valor) {
		String jpql = """
                SELECT o FROM Orcamento o WHERE o.valor >= :valor
            """;

		return getEntityManager()
            .createQuery(jpql, Orcamento.class)
            .setParameter("valor", valor)
            .getResultStream()
            .toList();
	}


	@Override
	public List<Orcamento> listarPelaDataValidade(LocalDate data) {
		String jpql = """
                SELECT o FROM Orcamento o WHERE o.dataValidade = :data
            """;

		return getEntityManager()
            .createQuery(jpql, Orcamento.class)
            .setParameter("data", data)
            .getResultStream()
            .toList();
	}
	
	@Override
	public Orcamento listarOrcamentoPeloCodigo(Long id) {
        String jpql = """
                SELECT o FROM Orcamento o WHERE o.id = :codigo
            """;

    return getEntityManager()
            .createQuery(jpql, Orcamento.class)
            .setParameter("codigo", id)
            .getResultStream()
            .findAny()
            .orElseThrow();
	}

	@Override
	public void salvar(Orcamento orcamento) {
		persist(orcamento);		
	}

}
