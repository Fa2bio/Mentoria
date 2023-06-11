package org.edu.unidep.domain.repository;

import java.time.LocalDate;
import java.util.List;

import org.edu.unidep.domain.model.Pedido;

public interface PedidoRepository {
	List<Pedido> listar();
	List<Pedido> listarPelaData(LocalDate data);
	List<Pedido> listarPeloNomeCliente(String nome);
	Pedido listarPeloCodigo(Long id);
	void criar(Pedido pedido);
}
