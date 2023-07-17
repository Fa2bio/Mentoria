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
	
	public List<Pedido> listar(){
		return pedidoRepository.listar();
	}
	
	public List<Pedido> listarPelaData(LocalDate data){
		return pedidoRepository.listarPelaData(data);
	}
	
	public List<Pedido> listarPeloNomeCliente(String nome){
		return pedidoRepository.listarPeloNomeCliente(nome);
	}
	
	public Pedido buscarPeloCodigo(Long id) {
		return pedidoRepository.listarPeloCodigo(id);
	}
	
	@Transactional
	public void criar(PedidoModel pedidoModel) {
		Pedido pedido = new Pedido();
		pedido.setDataEmissao(pedidoModel.data());
		
		Cliente cliente = clienteService.buscarPorCodigo(pedidoModel.cliente().id());
		pedido.setCliente(cliente);
		
		Orcamento orcamento = orcamentoService.buscarPeloCodigo(pedidoModel.orcamento().id());
		
		pedido.setOrcamento(orcamento);
		
		pedidoRepository.criar(pedido);
	}
}
