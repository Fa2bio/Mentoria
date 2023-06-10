package org.edu.unidep.domain.service;

import java.time.LocalDate;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

import org.edu.unidep.api.dto.model.PedidoModel;
import org.edu.unidep.domain.model.Cliente;
import org.edu.unidep.domain.model.Orcamento;
import org.edu.unidep.domain.model.Pedido;
import org.edu.unidep.domain.repository.PedidoRepository;

@ApplicationScoped
public class PedidoService {

	@Inject
	private PedidoRepository pedidoRepository;
	
	@Inject 
	private ClienteService clienteService;
	
	@Inject 
	private OrcamentoService orcamentoService;
	
	public List<Pedido> listar() {
		return pedidoRepository.listar();
	}  
	
	public List<Pedido> listarPelaData(LocalDate data) {
		return pedidoRepository.listarPelaData(data);
	} 
	
	public List<Pedido> listarPeloNomeCliente(String nome) {
		return pedidoRepository.listarPeloNomeCliente(nome);
	} 
	
	public Pedido buscarPorCodigo(Long id) {
		return pedidoRepository.listarPedidoPeloCodigo(id);
	}
	
	@Transactional
	public void salvar(PedidoModel pedidoInput) {
		Pedido pedido = new Pedido();
		pedido.setData(pedidoInput.data());
		
		Cliente cliente = clienteService.buscarPorCodigo(pedidoInput.cliente().id());
		pedido.setCliente(cliente);
		
		Orcamento orcamento = orcamentoService.buscarPorCodigo(pedidoInput.orcamento().id());
		pedido.setOrcamento(orcamento);

		pedidoRepository.salvar(pedido);
	}
	
}
