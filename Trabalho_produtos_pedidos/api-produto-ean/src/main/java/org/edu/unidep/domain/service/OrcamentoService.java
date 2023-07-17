package org.edu.unidep.domain.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

import org.edu.unidep.api.dto.assembler.ItemAssembler;
import org.edu.unidep.api.dto.model.OrcamentoModel;
import org.edu.unidep.domain.model.Item;
import org.edu.unidep.domain.model.Orcamento;
import org.edu.unidep.domain.repository.OrcamentoRepository;

@ApplicationScoped
public class OrcamentoService {

	@Inject
	private OrcamentoRepository orcamentoRepository;
	
	@Inject
	private ItemAssembler itemAssembler;
	
	public List<Orcamento> listar(){
		return orcamentoRepository.listar();
	}
	
	public List<Orcamento> buscarPelaData(LocalDate data){
		return orcamentoRepository.listarPelaData(data);
	}
	
	public List<Orcamento> buscarPelaDataValidade(LocalDate dataValidade){
		return orcamentoRepository.listarPelaDataValidade(dataValidade);
	}
	
	public List<Orcamento> buscarPeloValor(BigDecimal valor){
		return orcamentoRepository.listarPorMaiorValor(valor);
	}
	
	public Orcamento buscarPeloCodigo(Long id) {
		return orcamentoRepository.listarPeloCodigo(id);
	}
	
	@Transactional
	public void criar(OrcamentoModel orcamentoModel) {
		Orcamento orcamento = new Orcamento();
		orcamento.setData(orcamentoModel.data());
		orcamento.setDataValidade(orcamentoModel.dataValidade());
		List<Item> itens = itemAssembler.toCollectionDomainObject(orcamentoModel.itens(), orcamento);
		orcamento.setItens(itens);
		orcamento.calcularValorTotal();
		
		orcamentoRepository.criar(orcamento);
	}
}
