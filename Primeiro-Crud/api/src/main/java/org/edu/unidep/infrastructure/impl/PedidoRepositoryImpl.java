package org.edu.unidep.infrastructure.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

import org.edu.unidep.domain.model.Pedido;
import org.edu.unidep.domain.repository.PedidoRepository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class PedidoRepositoryImpl implements PedidoRepository,
PanacheRepository<Pedido>{

	@Override
	public List<Pedido> listar() {
		return listAll();
	}

	@Override
	public List<Pedido> listarPelaData(LocalDate data) {
		
		String jpql = """
				SELECT p FROM Pedido p WHERE p.dataEmissao = :data
				""";
		
		return getEntityManager()
				.createQuery(jpql, Pedido.class)
				.setParameter("data", data)
				.getResultStream()
				.toList();
	}

	@Override
	public List<Pedido> listarPeloNomeCliente(String nomeCliente) {
		
		String jpql = """
				SELECT p FROM Pedido p JOIN Cliente c ON c.nome = :nomeCliente AND p.cliente.id = c.id
				""";
		
		return getEntityManager()
				.createQuery(jpql, Pedido.class)
				.setParameter("nomeCliente", nomeCliente)
				.getResultStream()
				.toList();
	}

	@Override
	public List<Pedido> listarPeloNomeFuncionario(String nomeFuncionario) {
		
		String jpql = """
				SELECT p FROM Pedido p JOIN Funcionario f ON f.nome = :nomeFuncionario AND p.funcionario.id = f.id
				""";
		
		return getEntityManager()
				.createQuery(jpql, Pedido.class)
				.setParameter("nomeFuncionario", nomeFuncionario)
				.getResultStream()
				.toList();
	}

	@Override
	public Optional<Pedido> buscarPorId(Long id) {
		return findByIdOptional(id);
	}
	
	@Override
	public Optional<Pedido> buscarPeloCodigoPedido(String codigo) {
		String jpql = """
				SELECT p FROM Pedido p WHERE p.uuidCode = :codigo
				""";
		
		return getEntityManager()
				.createQuery(jpql, Pedido.class)
				.setParameter("codigo", codigo)
				.getResultStream()
				.findAny();
	}

	@Override
	@Transactional
	public void salvar(Pedido pedido) {
		persist(pedido);
	}



}
