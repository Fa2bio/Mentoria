package org.edu.unidep.domain.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.edu.unidep.domain.model.Pedido;

public interface PedidoRepository {
	List<Pedido> listar();
	List<Pedido> listarPelaData(LocalDate data);
	List<Pedido> listarPeloNomeCliente(String nomeCliente);
	List<Pedido> listarPeloNomeFuncionario(String nomeFuncionario);
	Optional<Pedido> buscarPorId(Long id);
	Optional<Pedido> buscarPeloCodigoPedido(String codigo);
	void salvar(Pedido pedido);
}
