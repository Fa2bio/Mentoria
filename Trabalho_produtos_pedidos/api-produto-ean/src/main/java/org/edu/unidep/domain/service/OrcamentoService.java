package org.edu.unidep.domain.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

import org.edu.unidep.api.dto.assembler.ItemAssembler;
import org.edu.unidep.api.dto.model.OrcamentoModel;
import org.edu.unidep.domain.model.Orcamento;
import org.edu.unidep.domain.repository.OrcamentoRepository;

@ApplicationScoped
public class OrcamentoService {
	
	@Inject
	private OrcamentoRepository orcamentoRepository;
	
	@Inject
	private ItemAssembler itemAssembler;
	
	public List<Orcamento> listar() {
		return orcamentoRepository.listar();
	}
	
	public List<Orcamento> buscarPelaData(LocalDate data) {
		return orcamentoRepository.listarPelaData(data);
	}
	
	public List<Orcamento> buscarPelaDataValidade(LocalDate data) {
		return orcamentoRepository.listarPelaDataValidade(data);
	}
	
	public List<Orcamento> buscarPeloValor(BigDecimal valor) {
		return orcamentoRepository.listarPeloMaiorValor(valor);
	}
	
	public Orcamento buscarPorCodigo(Long id) {
		return orcamentoRepository.listarOrcamentoPeloCodigo(id);
	}
	
    @Transactional
    public void salvar(OrcamentoModel orcamentoModel){
    	Orcamento orcamento = new Orcamento();
    	orcamento.setData(orcamentoModel.data());
    	orcamento.setDataValidade(orcamentoModel.dataValidade());
    	orcamento.setItens(itemAssembler.toCollectionDomainObject(orcamentoModel.itens(), orcamento));
    	orcamento.calcularValorTotal();
    	
    	orcamentoRepository.salvar(orcamento);
    }

}
