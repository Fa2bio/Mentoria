package org.edu.unidep.infrastrucute.impl;

import java.time.LocalDate;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import org.edu.unidep.domain.model.Pedido;
import org.edu.unidep.domain.repository.PedidoRepository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class PedidoImpl implements PanacheRepository<Pedido>,
	PedidoRepository{

	@Override
	public List<Pedido> listar() {
		return listAll();
	}

	@Override
	public List<Pedido> listarPelaData(LocalDate data) {
		String jpql = """
                SELECT p FROM Pedido p WHERE p.data = :data
            """;

		return getEntityManager()
            .createQuery(jpql, Pedido.class)
            .setParameter("data", data)
            .getResultStream()
            .toList();
	}

	@Override
	public List<Pedido> listarPeloNomeCliente(String nome) {
		String jpql = """
                SELECT p FROM Pedido p INNER JOIN Cliente c ON c.nome = :nome AND p.cliente.id=c.id
            """;

		return getEntityManager()
            .createQuery(jpql, Pedido.class)
            .setParameter("nome", nome)
            .getResultStream()
            .toList();
	}

	@Override
	public Pedido listarPedidoPeloCodigo(Long id) {
        String jpql = """
                SELECT p FROM Pedido p WHERE p.id = :codigo
            """;

    return getEntityManager()
            .createQuery(jpql, Pedido.class)
            .setParameter("codigo", id)
            .getResultStream()
            .findAny()
            .orElseThrow();
	}

	@Override
	public void salvar(Pedido pedido) {
		 persist(pedido);		
	}

}
