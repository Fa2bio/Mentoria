package org.edu.unidep.domain.repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.edu.unidep.domain.model.Orcamento;

public interface OrcamentoRepository {
	List<Orcamento> listar();
	List<Orcamento> listarPelaData(LocalDate data);
	List<Orcamento> listarPelaDataValidade(LocalDate data);
	List<Orcamento> listarPorMaiorValor(BigDecimal valor);
	Orcamento listarPeloCodigo(Long id);
	void criar(Orcamento orcamento);
}
