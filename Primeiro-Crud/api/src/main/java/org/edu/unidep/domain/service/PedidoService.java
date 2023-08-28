package org.edu.unidep.domain.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;

import org.edu.unidep.api.dto.modelmapper.assembler.ItemAssembler;
import org.edu.unidep.api.dto.modelmapper.request.PedidoRequest;
import org.edu.unidep.domain.exception.PedidoNaoEncontradoException;
import org.edu.unidep.domain.model.Cliente;
import org.edu.unidep.domain.model.Funcionario;
import org.edu.unidep.domain.model.Item;
import org.edu.unidep.domain.model.Pedido;
import org.edu.unidep.domain.repository.PedidoRepository;

@ApplicationScoped
public class PedidoService {

	@Inject
	private PedidoRepository pedidoRepository;
	
	@Inject
	private ClienteService clienteService;
	
	@Inject
	private FuncionarioService funcionarioService;

	@Inject
	private ItemAssembler itemAssembler;
	
	@Inject
	private Validator validator;
	
	public void validarPedidoRequest(PedidoRequest pedidoRequest) {
		Set<ConstraintViolation<PedidoRequest>> constraintViolations = validator.validate(pedidoRequest);
		if(constraintViolations.isEmpty()) return;
		else throw new ConstraintViolationException(constraintViolations);
	}
	
	public List<Pedido> listarTodosPedido(){
		return pedidoRepository.listar();
	}
	
	public List<Pedido> listarPelaData(LocalDate data){
		return pedidoRepository.listarPelaData(data);
	}
	
	public List<Pedido> listarPeloNomeCliente(String nomeCliente){
		return pedidoRepository.listarPeloNomeCliente(nomeCliente);
	}
	
	public List<Pedido> listarPeloNomeFuncionario(String nomeFuncionario){
		return pedidoRepository.listarPeloNomeFuncionario(nomeFuncionario);
	}
	
	public Pedido buscarOuFalhar(Long id) {
		return pedidoRepository.buscarPorId(id)
				.orElseThrow(()-> new PedidoNaoEncontradoException(id));
	}
	
	public Pedido buscarPeloCodigo(String codigo) {
		return pedidoRepository.buscarPeloCodigoPedido(codigo)
				.orElseThrow(()-> new PedidoNaoEncontradoException(codigo));
	}
	
	@Transactional
	public void salvarPedido(PedidoRequest pedidoRequest) {
		Cliente cliente = clienteService.buscarOuFalhar(pedidoRequest.getClienteId());
		Funcionario funcionario = funcionarioService.buscarOuFalhar(pedidoRequest.getFuncionarioId());
		cliente.addFuncionario(funcionario);
		
		Pedido pedido = new Pedido();
		pedido.setCliente(cliente);
		pedido.setFuncionario(funcionario);
		pedido.setDataEmissao(pedidoRequest.getDataEmissao());
		List<Item> itens = itemAssembler.toCollectionModel(pedidoRequest.getItens(), pedido);
		pedido.setItens(itens);
		pedido.calcularValorTotal();
		
		pedidoRepository.salvar(pedido);
	}
	
}
