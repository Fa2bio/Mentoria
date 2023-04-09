package org.edu.unidep.domain.model;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.smallrye.common.constraint.NotNull;

@Entity
@Table(name = "pessoa")
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_pessoa")
	private Long id;
    
    @NotNull
    @Column(name = "nome", length = 100)
	private String nome;
    
    @NotNull
    @Column(name = "data_de_aniversario", length = 10)
	private String dataAniversario;
    
    @NotNull
    @Column(name = "tipo_sanguineo", length = 3)
	private String sangue;
    
    @Embedded
    private Endereco endereco;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDataAniversario() {
		return dataAniversario;
	}

	public void setDataAniversario(String dataAniversario) {
		this.dataAniversario = dataAniversario;
	}

	public String getSangue() {
		return sangue;
	}

	public void setSangue(String sangue) {
		this.sangue = sangue;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
    
}
