package org.edu.unidep.domain.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "orcamento")
public class Orcamento implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_orcamento")
    private Long id;
	
    @Column(name = "data", nullable = false)
    private LocalDate data;
	
    @Column(name = "data_validade", nullable = false)
    private LocalDate dataValidade;
    
    @Column(name = "valor", nullable = false)
    private BigDecimal valor;
    
    @OneToOne(mappedBy = "orcamento")
    private Pedido pedido;

    @OneToMany(mappedBy = "orcamento", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Item> itens = new ArrayList<>();
    
    public void calcularValorTotal() {
    	getItens().forEach(Item::calcularValorTotal);
    	this.valor = getItens().stream()
    			.map(item -> item.getValorTotal())
    			.reduce(BigDecimal.ZERO, BigDecimal::add);
    }
    
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public LocalDate getDataValidade() {
		return dataValidade;
	}

	public void setDataValidade(LocalDate dataValidade) {
		this.dataValidade = dataValidade;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public List<Item> getItens() {
		return itens;
	}

	public void setItens(List<Item> itens) {
		this.itens = itens;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
    
}
