package org.edu.unidep.domain.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "item")
public class Item {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "codigo_item")
	private Long id;
	
	@Column(name = "quantidade", nullable = false)
	private Integer quantidade;
	
	@Column(name = "valor_total", nullable = false)
	private BigDecimal valorTotal;
	
	@Column(name = "valor_unitario", nullable = false)
	private BigDecimal valorUnitario;
	
	@ManyToOne
	private Produto produto;
	
	@ManyToOne
	@JoinColumn(name = "codigo_orcamento")
	private Orcamento orcamento;

	public void calcularValorTotal() {
		BigDecimal valorProduto = this.valorUnitario;
		Integer qtdProdutos = this.quantidade;
		
		if(valorProduto == null) valorProduto = BigDecimal.ZERO;
		if(qtdProdutos == null) qtdProdutos = 0;
		
		setValorTotal(valorProduto.multiply(new BigDecimal(qtdProdutos)));
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

	public BigDecimal getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(BigDecimal valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Orcamento getOrcamento() {
		return orcamento;
	}

	public void setOrcamento(Orcamento orcamento) {
		this.orcamento = orcamento;
	}

}
